package org.sagar.email;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
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
        String password = "aicevlqfpcovgwuj ";

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

    public boolean sendEmailWithAttachment(String mailTo, String mailFrom, String subject, String text, File file) {
        boolean flag = false;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");

        String username = "sagargandhi968";
        String password = "aicevlqfpcovgwuj ";

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

            MimeBodyPart part1 = new MimeBodyPart();
            part1.setText(text);

            MimeBodyPart part2 = new MimeBodyPart();
            part2.attachFile(file);

            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(part1);
            multipart.addBodyPart(part2);

            message.setContent(multipart);

            Transport.send(message);
            flag = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return flag;
    }
}
