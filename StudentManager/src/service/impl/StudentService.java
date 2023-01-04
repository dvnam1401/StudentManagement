package service.impl;

import model.Student;
import service.IStudentArray;
import view.StudentView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentService implements IStudentArray<Student> {
    public static List<Student> studentList = new ArrayList<>();
    private StudentView studentView;

    public StudentService() {
    }

    public StudentService(StudentView studentView) {
        this.studentView = studentView;
    }

    @Override
    // kiểm tra mã sinh viên trùng lặp
    public boolean checkID(int idStudent) {
        for (Student value : studentList) {
            if (value.getCode() == idStudent) {
                return true;
            }
        }
        return false;
    }

    @Override
    // kiểm tra tên đúng định dạng
    // tên k được chứa kí tự
    public boolean checkName(String name) {
        name = name.toLowerCase();
        for (int i = 0; i < name.length() - 1; ++i) {
            if (Character.isLetter(name.charAt(i)) || (name.charAt(i)) == ' ') {
                return true;
            }
        }
        return false;
    }

    @Override
    // chỉnh sửa tên về đúng form
    // in hoa chữ cái đầu.
    public String formatName(String nameStudent) {
        char[] arrayName = nameStudent.toCharArray();
        boolean flag = true;
        //duyệt các phần tử trong mảng
        for (int i = 0; i < arrayName.length; i++) {
            // nếu pt trong mảng là chữ
            if (Character.isLetter(arrayName[i])) {
                // kiểm tra khoảng trắng phía trước có chữ cái
                if (flag) {
                    // đổi chữ hoa thành thường.
                    arrayName[i] = Character.toUpperCase(arrayName[i]);
                    flag = false;
                }
            } else {
                flag = true;
            }
        }
        nameStudent = String.valueOf(arrayName);
        return nameStudent;
    }

    @Override
    // kiểm tra phạm vi điểm
    public boolean checkPoint(double point) {
        return point >= 0 && point <= 10;
    }

    // chèn sinh viên
    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    // tìm kiếm sinh viên theo id
    @Override
    public Student searchId(int code) {
        Student student = new Student();
        for (Student value : studentList) {
            if (value.getCode() == code) {
                student = value;
            }
        }
        return student;
    }


    // xóa sinh viên theo id
    @Override
    public void deleteId(int code) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getCode() == code) {
                studentList.remove(i);
                return;
            }
        }
    }

    // xóa sinh viên
    @Override
    public void deleteStudent(Student student) {
        studentList.remove(student);
    }

    // xóa tất cả sinh viên trong class
    @Override
    public boolean deleteStudent(String nameClass) {
        List<Student> toRemove = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getClassName().trim().equals(nameClass)) {
                toRemove.add(student);
            }
        }
        if (!toRemove.isEmpty()) {
            studentList.removeAll(toRemove);
            return true;
        }
        return false;
    }

    // kiểm tra sinh viên có tồn tại vs class và id cho sẵn không
    @Override
    public boolean searchIdClass(String className, int idSearch) {
        for (Student student : studentList) {
            if (student.getClassName().trim().equals(className) && student.getCode() == idSearch) {
                return true;
            }
        }
        return false;
    }

    // tìm sinh viên có điểm cao nhất đầu tiên
    @Override
    public Student searchPoint() {
        Student student = new Student();
        Collections.sort(studentList);
        if (studentList.size() == 1) {
            student = studentList.get(0);
        } else {
            for (int i = studentList.size() - 1; i >= 0; i--) {
                if (studentList.get(i).getAverageGrade() > studentList.get(i - 1).getAverageGrade()) {
                    student = studentList.get(i);
                    break;
                }
            }
        }
        return student;
    }

    public void showStudentView() {
        studentView.setVisible(true);
    }
}
