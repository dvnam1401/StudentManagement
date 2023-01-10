package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginView;
import view.StudentView;

import javax.swing.*;

public class StudentController implements ActionListener {
    private final StudentView studentView;

    public StudentController(StudentView studentView) {
        super();
        this.studentView = studentView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        switch (button) {
            case "Thêm" -> {
                this.studentView.clearInput();
                System.out.println("Da nhan them");
            }

            case "Lưu" -> {
                System.out.println("Da nhan luu");
                this.studentView.getStudentInfo();
            }
            case "Cập nhật" -> {
                System.out.println("Da nhan cập nhật");
                this.studentView.showListStudents();
            }

            case "Xóa" -> {
                System.out.println("Da nhan xoa");
                this.studentView.deleteStudent();
            }

            case "Hủy bỏ" -> {
                System.out.println("Da nhan hủy bỏ");
                int choose = JOptionPane.showConfirmDialog(new Frame(),
                        "Bạn có muốn hủy bỏ thao tác?",
                        "Cảnh báo", JOptionPane.YES_NO_OPTION);
                if (choose == JOptionPane.YES_OPTION) {
                    this.studentView.clearInput();
                }
            }

            case "Tìm" -> {
                System.out.println("Dang nhan tìm");
                this.studentView.searchStudent();
            }

            case "Điểm trung bình cao nhất" -> {
                System.out.println("Da nhan diem trung binh");
                Icon icon = new ImageIcon(Toolkit.getDefaultToolkit().
                        createImage(LoginView.class.getResource("/data/imageStudent/smile-lol-icon.png")));
                JOptionPane.showMessageDialog(new JFrame(),
                        this.studentView.maxAverageScore(),
                        "Inane custom dialog",
                        JOptionPane.INFORMATION_MESSAGE,
                        icon);
            }

            case "Open" -> {
                System.out.println("Da an mo file");
                this.studentView.openFile();
            }

            case "Save" -> {
                System.out.println("Da nhan save");
                this.studentView.saveFile();
            }

            case "Exit" -> {
                System.out.println("Da nhan exit");
                this.studentView.exitProgram();
            }

            case "About me" -> {
                System.out.println("da nhan about me");
                this.studentView.aboutMe();
            }

            case "Theo lớp" -> {
                System.out.println("Da nhan xóa sinh viên");
                this.studentView.deleteStudentClass();
            }

            case "Mã sinh viên" -> {
                System.out.println("Da nhan ma sinh viên");
                this.studentView.deleteStudentId();
            }
        }
    }
}
