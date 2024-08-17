package Model;

import Repositpry.ApplicationNotification;

public class User {

    private String name;
    private String email;
    private String phone;

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void sendNotification(ApplicationNotification notification, User toUser, String message){
        notification.sendNotification(this, toUser, message);
    }
}
