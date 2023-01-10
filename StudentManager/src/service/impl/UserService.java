package service.impl;

import model.User;

public class UserService {
    public boolean checkLogin(User user) {
            return "admin".equals(user.getUserName()) && "admin".equals(user.getPassWord());
    }
}
