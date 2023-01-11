import view.LoginView;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            new LoginView();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            new LoginView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
