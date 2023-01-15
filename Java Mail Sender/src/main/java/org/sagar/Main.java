package org.sagar;

import org.sagar.email.EmailSender;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        EmailSender emailSender = new EmailSender();
        String mailTo = "khushhal1901@gmail.com";
        String mailFrom = "sagargandhi968@gmail.com";
        String subject = "Test Email with attachment";
        String text = "This is a test email with attachment which is being sent from java code.";
        File file = new File("D:\\Photo.jpg");

        boolean isEmailSent = emailSender.sendEmailWithAttachment(mailTo, mailFrom, subject, text, file);
        if (isEmailSent) {
            System.out.println("Email sent successfully...");
        } else {
            System.out.println("There is a problem in sending email.");
        }

//        boolean isEmailSent = emailSender.sendEmail(mailTo, mailFrom, subject, text);
//        if (isEmailSent) {
//            System.out.println("Email sent successfully...");
//        } else {
//            System.out.println("There is a problem in sending email.");
//        }


    }
}