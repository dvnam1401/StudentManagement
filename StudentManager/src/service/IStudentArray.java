package service;

import model.Student;

public interface IStudentArray {

    boolean checkID(int idStudent);
    boolean checkName(String name);
    String formatName(String nameStudent);
    boolean checkPoint(double point);
    void add(Student student);

    Student searchId(int code);

    void deleteId(int code);

    void deleteStudent(Student student);
    boolean deleteStudent(String nameClass);

    boolean searchIdClass(String student, int idSearch);

    Student searchPoint();
}
