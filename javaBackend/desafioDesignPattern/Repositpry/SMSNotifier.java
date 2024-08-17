package Repositpry;

import Model.User;

public class SMSNotifier implements ApplicationNotification {
    @Override
    public void sendNotification(User userFrom, User userTo, String message) {
        System.out.println("Enviando SMS " +
                "de " + userFrom.getPhone() + " " +
                "para " + userTo.getPhone() +
                "\n" + "Com a seguinte messagem");
        System.out.println("\t" + message);
    }
}
