import view.LoginView;
import view.StudentView;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new LoginView();
//            new StudentView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
