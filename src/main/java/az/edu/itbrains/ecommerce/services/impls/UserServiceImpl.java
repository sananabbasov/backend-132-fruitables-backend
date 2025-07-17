package az.edu.itbrains.ecommerce.services.impls;

import az.edu.itbrains.ecommerce.dtos.auth.RegisterDto;
import az.edu.itbrains.ecommerce.dtos.user.UserDto;
import az.edu.itbrains.ecommerce.models.User;
import az.edu.itbrains.ecommerce.repositories.UserRepository;
import az.edu.itbrains.ecommerce.services.EmailService;
import az.edu.itbrains.ecommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public boolean registerUser(RegisterDto registerDto) {
        try {
            User user = new User();
            UUID uuid = UUID.randomUUID();
            User findUser = userRepository.findByEmail(registerDto.getEmail());
            if (findUser != null){
                return false;
            }
            String emailToken = uuid.toString().replace("-","");
            user.setEmail(registerDto.getEmail());
            user.setFirstName(registerDto.getFirstName());
            user.setLastName(registerDto.getLastName());
            String password = passwordEncoder.encode(registerDto.getPassword());
            user.setPassword(password);
            user.setEmailConfirmed(false);
            user.setEmailToken(emailToken);
            userRepository.save(user);
            emailService.sendConfirmationEmail(user.getEmail(),user.getEmailToken());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean confirmEmail(String email, String token) {
        User findUser = userRepository.findByEmail(email);
        if (findUser == null){
            return false;
        }

        if (findUser.getEmailToken().equals(token)){
            findUser.setEmailConfirmed(true);
            userRepository.save(findUser);
            return true;
        }

        return false;
    }

    @Override
    public User findUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

    @Override
    public UserDto findUserDtoByEmail(String userEmail) {
        User user = userRepository.findByEmail(userEmail);
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
