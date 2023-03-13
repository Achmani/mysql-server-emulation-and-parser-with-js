package id.mit.chrono.server.test;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    public static void main(String [] args) {
        // Recipient's email ID needs to be mentioned.
        String to = "whiledan@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "notifier@chrono.telkomsel.co.id";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", "localhost");
        properties.put("mail.smtp.auth", "false");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
