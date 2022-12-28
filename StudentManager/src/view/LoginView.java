package view;

import controller.LoginController;
import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

public class LoginView extends JFrame {

    public JPanel contentPane;
    public JTextField userNameField;
    public JPasswordField passwordField;
    public JButton loginBtn;
    public JLabel iconLogin;

    public LoginView() {
        ActionListener actionListener = new LoginController(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 377, 433);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // hình ảnh cho JFame.
        URL urllUrl = LoginView.class.getResource("/data/imageLogin/icon.png");
        Image image = Toolkit.getDefaultToolkit().createImage(urllUrl);
        this.setIconImage(image);

        JLabel titleLogin = new JLabel("MEMBER LOGIN");
        titleLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleLogin.setBounds(116, 150, 142, 63);
        contentPane.add(titleLogin);

        JLabel userNameLabel = new JLabel("Username");
        userNameLabel.setIcon(
                new ImageIcon(Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/data/imageLogin/login.png"))));
        userNameLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
        userNameLabel.setBounds(30, 210, 140, 32);
        contentPane.add(userNameLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setIcon(new ImageIcon(
                Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/data/imageLogin/password.png"))));
        passwordLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
        passwordLabel.setBounds(30, 257, 140, 32);
        contentPane.add(passwordLabel);

        userNameField = new JTextField();
        userNameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        userNameField.setBounds(163, 212, 156, 28);
        contentPane.add(userNameField);
        userNameField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        passwordField.setColumns(10);
        passwordField.setBounds(163, 259, 156, 28);
        contentPane.add(passwordField);

        loginBtn = new JButton("LOGIN");
        loginBtn.addActionListener(actionListener);
        loginBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
        loginBtn.setBounds(133, 322, 113, 44);
        loginBtn.setBackground(Color.cyan);
        loginBtn.setMnemonic(KeyEvent.VK_ENTER);
        contentPane.add(loginBtn);

        iconLogin = new JLabel("");
        iconLogin.setIcon(new ImageIcon(
                Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/data/imageLogin/person.png"))));
        iconLogin.setFont(new Font("Tahoma", Font.ITALIC, 18));
        iconLogin.setBounds(117, 27, 156, 130);
        contentPane.add(iconLogin);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public User getUser() {
        return new User(userNameField.getText(), String.copyValueOf(passwordField.getPassword()));
    }
}