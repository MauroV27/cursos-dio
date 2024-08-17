package Repositpry;

import Model.User;

public interface ApplicationNotification {
    void sendNotification(User userFrom, User userTo, String message);
}
