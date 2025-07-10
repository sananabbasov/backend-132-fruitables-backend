package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.dtos.auth.RegisterDto;

public interface UserService {
    boolean registerUser(RegisterDto registerDto);

    boolean confirmEmail(String email, String token);
}
