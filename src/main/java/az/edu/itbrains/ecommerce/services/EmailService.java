package az.edu.itbrains.ecommerce.services;

public interface EmailService {
    boolean sendConfirmationEmail(String email, String token);
}
