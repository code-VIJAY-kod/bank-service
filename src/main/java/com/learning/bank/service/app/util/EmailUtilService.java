package com.learning.bank.service.app.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
@Slf4j
public class EmailUtilService {
     private  static final String EMAIL_ID="vskedutech@gmail.com";
     private  static final String PASSWORD="dvby snor nait qamz";

    public void sendMail(int account,double debitAmount,double balance,String note){
        Properties properties=new Properties();
        properties.setProperty("mail.smtp.host","smtp.gmail.com");
        properties.setProperty("mail.smtp.port","587");
        properties.setProperty("mail.smtp.auth","true");
        properties.setProperty("mail.smtp.starttls.enable","true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_ID,PASSWORD);
            }
        });
        Message message =new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("vskedutech@gmail.com"));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress("vskedu@gmail.com"));
            message.setSubject("Transaction on account");
            message.setText("Account: "+account+"\n"+"Debit: "+debitAmount+"\nBal: "+balance+"\nNote: "+note);

            Transport.send(message);
        } catch (MessagingException e) {
            log.error("mail not sent");
        }
         log.info("mail sent successfully");
    }
}
