package service.impl;

import model.User;

public class UserService {
    public boolean checkLogin(User user) {
        if (user != null) {
            return "admin".equals(user.getUserName()) && "admin".equals(user.getPassWord());
        }
        return false;
    }
}
