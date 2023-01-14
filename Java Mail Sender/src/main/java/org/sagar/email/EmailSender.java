package org.sagar.email;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailSender {

    public boolean sendEmail(String mailTo, String mailFrom, String subject, String text) {
        boolean flag = false;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");

        String username = "sagargandhi968";
        String password = "aicevlqfpcovgwuj";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
            message.setFrom(new InternetAddress(mailFrom));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
            flag = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return flag;
    }
}
