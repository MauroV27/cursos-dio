import Model.User;
import Repositpry.EmailNotifier;
import Repositpry.SMSNotifier;

public class Main {

    public static void main(String[] args) {

        EmailNotifier emailNotifier = new EmailNotifier();
        SMSNotifier smsNotifier = new SMSNotifier();
        
        User mauro = new User("Mauro", "mauro@email.com", "1234");
        User vitor = new User("Vitor", "vitor@email.com", "9876");

        mauro.sendNotification(smsNotifier, vitor, "Oi manda um email para : " + mauro.getEmail());
        vitor.sendNotification(emailNotifier, mauro, "Oi, esse é meu email!");
    }
}
