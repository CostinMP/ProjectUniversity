package university.service.email;

public interface EmailSender {
    void sendEmail(String toEmail, String subject, String body);
}