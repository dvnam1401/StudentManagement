package service;

public interface IStudentArray<E> {

    boolean checkID(int idStudent);
    boolean checkName(String name);
    String formatName(String nameStudent);
    boolean checkPoint(double point);
    void add(E student);

    E searchId(int code);

    void deleteId(int code);

    void deleteStudent(E student);
    boolean deleteStudent(String nameClass);

    boolean searchIdClass(String student, int idSearch);

    E searchPoint();
}
