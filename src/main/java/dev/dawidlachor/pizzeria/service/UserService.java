package dev.dawidlachor.pizzeria.service;

import dev.dawidlachor.pizzeria.exception.VerificationTokenException;
import dev.dawidlachor.pizzeria.model.Customer;
import dev.dawidlachor.pizzeria.dto.RegisterRequestDto;
import dev.dawidlachor.pizzeria.model.NotificationEmail;
import dev.dawidlachor.pizzeria.model.User;
import dev.dawidlachor.pizzeria.model.VerificationToken;
import dev.dawidlachor.pizzeria.repository.CustomerRepository;
import dev.dawidlachor.pizzeria.repository.UserRepository;
import dev.dawidlachor.pizzeria.repository.VerificationTokenRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailService mailService;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, CustomerRepository customerRepository, VerificationTokenRepository verificationTokenRepository, MailService mailService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.verificationTokenRepository = verificationTokenRepository;
        this.mailService = mailService;
    }

    public void signup(RegisterRequestDto registerRequest){
        User user = new User();
        user.setLogin(registerRequest.getLogin());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEnabled(false);

        Customer customer = new Customer();
        customer.setAddress(registerRequest.getAddress());
        customer.setBirth(registerRequest.getBirth());
        customer.setUser(user);

        userRepository.save(user);
        customerRepository.save(customer);

        String token = generateVerificationToken(user);
        mailService.sendMail(new NotificationEmail("Please Activate your Account", user.getEmail(), "Active your account by link: http://localhost:8080/api/auth/accountVerification/" + token));
    }

    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationToken.setExpiryDate(LocalDate.now());
        verificationTokenRepository.save(verificationToken);
        return token;
    }

    public void verification(String token) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token).orElseThrow(VerificationTokenException::new);
        User user = verificationToken.getUser();
        user.setEnabled(true);
        userRepository.save(user);
    }
}
