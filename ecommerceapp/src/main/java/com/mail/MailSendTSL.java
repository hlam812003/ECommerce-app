package com.mail;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MailSendTSL {
    public static void sendEmail(String recipientsEmail, String subject, String htmlContent) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", MailConfig.HOST);
        props.put("mail.smtp.port", MailConfig.PORT);

        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailConfig.USERNAME, MailConfig.PASSWORD);
            }
        };
        Session session = Session.getInstance(props, authenticator);

        try {
            // create a MimeMessage object
            Message message = new MimeMessage(session);
            // set From email field
            message.setFrom(new InternetAddress(MailConfig.FROM));
            // set To email field
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientsEmail));
            // set email subject field
            message.setSubject(subject);
            // set the content of the email message
            message.setContent(htmlContent, "text/html");
            // send the email message
            Transport.send(message);

            System.out.println("Message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
