package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginView;
import view.StudentView;

import javax.swing.*;

public class StudentController implements ActionListener {
    //        private StudentDao studentDao;
    private final StudentView studentView;


    public StudentController(StudentView studentView) {
        super();
        this.studentView = studentView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        switch (button) {
            case "Thêm":
                this.studentView.clearInput();
                System.out.println("Da nhan them");
                break;
            case "Lưu":
                System.out.println("Da nhan luu");
                try {
                    this.studentView.getStudentInfo();
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    exception.printStackTrace();
                }
                break;
            case "Cập nhật":
                System.out.println("Da nhan cập nhật");
                try {
                    this.studentView.showListStudents();
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    exception.printStackTrace();
                }
                break;
            case "Xóa":
                try {
                    System.out.println("Da nhan xoa");
                    this.studentView.deleteStudent();
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    exception.printStackTrace();
                }
                break;
            case "Hủy bỏ":
                try {
                    System.out.println("Da nhan hủy bỏ");
                    int choose = JOptionPane.showConfirmDialog(new Frame(),
                            "Bạn có muốn hủy bỏ thao tác?",
                            "Cảnh báo", JOptionPane.YES_NO_OPTION);
                    if (choose == JOptionPane.YES_OPTION) {
                        this.studentView.clearInput();
                    }
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    exception.printStackTrace();
                }
                break;
            case "Tìm":
                try {
                    System.out.println("Dang nhan tìm");
                    this.studentView.searchStudent();
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    exception.printStackTrace();
                }
                break;
            case "Điểm trung bình cao nhất":
                System.out.println("Da nhan diem trung binh");
                Icon icon = new ImageIcon(Toolkit.getDefaultToolkit().
                        createImage(LoginView.class.getResource("/data/imageStudent/smile-lol-icon.png")));
                JOptionPane.showMessageDialog(new JFrame(),
                        this.studentView.maxAverageScore(),
                        "Inane custom dialog",
                        JOptionPane.INFORMATION_MESSAGE,
                        icon);
                break;
            case "Open":
                System.out.println("Da an mo file");
                try {
                    this.studentView.openFile();
                } catch (Exception exception) {
                    exception.printStackTrace();
                    System.out.println(exception.getMessage());
                }
                break;
            case "Save":
                System.out.println("Da nhan save");
                try {
                    this.studentView.saveFile();
                } catch (Exception exception) {
                    exception.printStackTrace();
                    System.out.println(exception.getMessage());
                }
                break;
            case "Exit":
                System.out.println("Da nhan exit");
                this.studentView.exitProgram();
                break;
            case "About me":
                System.out.println("da nhan about me");
                break;
            case "Theo lớp":
                System.out.println("Da nhan xóa sinh viên");
                try {
                    this.studentView.deleteStudentClass();
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    exception.printStackTrace();
                }
                break;
            case "Mã sinh viên":
                try {
                    System.out.println("Da nhan ma sinh viên");
                    this.studentView.deleteStudentId();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                break;
        }
    }
}
