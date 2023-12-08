package com.mail;

import java.util.Properties;

import jakarta.mail.*;
import jakarta.mail.internet.*;

public class MailSendTSL {
    public static void sendEmail(String receiveEmail, String subject, String htmlContent) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", MailConfig.HOST_NAME);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", MailConfig.TSL_PORT);

        // get Session
        Session session = Session.getDefaultInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD);
            }
        });

        // compose message
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(MailConfig.APP_EMAIL));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiveEmail));
        message.setSubject(subject);
        message.setContent(htmlContent, "text/html");

        // send message
        Transport.send(message);

        System.out.println("Message sent successfully");
    }
}
