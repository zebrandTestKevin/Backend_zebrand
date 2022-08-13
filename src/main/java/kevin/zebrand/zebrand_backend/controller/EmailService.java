package kevin.zebrand.zebrand_backend.controller;

import kevin.zebrand.zebrand_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(List<User> userList, String subject, String content) {

        for (User c : userList)
        {
            SimpleMailMessage email = new SimpleMailMessage();

            //recorremos la lista y enviamos a cada cliente el mismo correo
            email.setFrom("testkevinsystems@gmail.com");
            email.setTo(c.getMail());
            email.setSubject(subject);
            email.setText(content);

            mailSender.send(email);
        }
    }
}
