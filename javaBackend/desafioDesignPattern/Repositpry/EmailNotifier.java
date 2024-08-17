package Repositpry;

import Model.User;

public class EmailNotifier implements ApplicationNotification {

    @Override
    public void sendNotification(User userFrom, User userTo, String message) {
        System.out.println("Enviando Email " +
            "de " + userFrom.getEmail() + " " +
            "para " + userTo.getEmail() +
            "\n" + "Com a seguinte messagem");
        System.out.println("\t" + message);

    }
}
