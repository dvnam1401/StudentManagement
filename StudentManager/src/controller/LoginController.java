package controller;

import model.User;
import service.impl.StudentService;
import service.impl.UserService;
import view.LoginView;
import view.StudentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginController implements ActionListener {
    private final UserService userService;
    private final LoginView loginView;

    public LoginController(LoginView loginView) {
        this.userService = new UserService();
        this.loginView = loginView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        User user = loginView.getUser();
        if (button.equals("LOGIN")) {
            if (userService.checkLogin(user)) {
                StudentView studentView = new StudentView();
                StudentService studentService = new StudentService(studentView);
                studentService.showStudentView();
                loginView.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(new JFrame(),
                        "Accounts or passwords are incorrect",
                        "Login unsuccessful",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}