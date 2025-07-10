package az.edu.itbrains.ecommerce.services.impls;

import az.edu.itbrains.ecommerce.services.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;


@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;


    @Override
    public boolean sendConfirmationEmail(String email, String token) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo("georgianna.shanahan@ethereal.email");
        message.setSubject("Confirmation");
        message.setText("http://localhost:8080/auth/emailConfirm?email="+email+"&token="+token);
        emailSender.send(message);
        return false;
    }
}
