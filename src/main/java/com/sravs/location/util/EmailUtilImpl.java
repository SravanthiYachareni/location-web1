package com.sravs.location.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component

public class EmailUtilImpl implements EmailUtil {

    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendEmail(String toAddress, String subject, String body) {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper mimeHelper = new MimeMessageHelper(message);
        try {
            mimeHelper.setTo(toAddress);
            mimeHelper.setSubject(subject);
            mimeHelper.setText(body);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);
    }
}
