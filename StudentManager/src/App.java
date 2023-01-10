import view.LoginView;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new LoginView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
