package com.shan.springmail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Async
    public void sendEmail(String to, String cc, String subject, List<User> users) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        // Thymeleaf context for the list of users
        Context context = new Context();
        context.setVariable("users", users);

        String emailContent = templateEngine.process("email", context);

        helper.setTo(to);
        helper.setCc(cc);  // Adding CC recipient
        helper.setSubject(subject);
        helper.setText(emailContent, true);

        mailSender.send(mimeMessage);
    }
}