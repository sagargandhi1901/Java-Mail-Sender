package org.sagar;

import org.sagar.email.EmailSender;

public class Main {
    public static void main(String[] args) {

        EmailSender emailSender = new EmailSender();
        String mailTo = "khushhal1901@gmail.com";
        String mailFrom = "sagargandhi968@gmail.com";
        String subject = "Test Email";
        String text = "This is a test email which is being sent from java code.";
        boolean isEmailSent = emailSender.sendEmail(mailTo, mailFrom, subject, text);

        if (isEmailSent) {
            System.out.println("Email sent successfully...");
        } else {
            System.out.println("There is a problem in sending email.");
        }
    }
}