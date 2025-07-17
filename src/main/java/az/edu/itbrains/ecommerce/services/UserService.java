package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.dtos.auth.RegisterDto;
import az.edu.itbrains.ecommerce.dtos.user.UserDto;
import az.edu.itbrains.ecommerce.models.User;

public interface UserService {
    boolean registerUser(RegisterDto registerDto);

    boolean confirmEmail(String email, String token);

    User findUserByEmail(String userEmail);
    UserDto findUserDtoByEmail(String userEmail);
}
