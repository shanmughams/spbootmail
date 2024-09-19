package com.shan.springmail;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send-email")
    public String sendEmail() {
        // Create a list of users
        List<User> users = new ArrayList<>();
        users.add(new User("John Doe", "Jane Smith", "Tech Solutions", "Business Class"));
        users.add(new User("Alice Johnson", "Bob Brown", "Finance Corp", "Executive Class"));
        users.add(new User("Charlie Davis", "Diana Green", "Marketing Inc", "Premium Class"));

        String to = "shanregs@gmail.com";
        String cc = "shansandroid@gmail.com";

        try {
            emailService.sendEmail(to, cc, "User List", users);
            return "Email sent successfully!";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending email.";
        }
    }
}