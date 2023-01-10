package model;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Comparable<Student>, Serializable {
    private int code; // mã sinh viên
    private String fullName; //họ và tên
    private String birthYear; // sinh năm
    private String className; // tên lớp
    private String sex; // giới tính
    private double averageGrade; // điểm trung bình.

    public Student() {
    }

    public Student(int code, String fullName, String birthYear, String className, String sex, double averageGrade) {
        this.code = code;
        this.fullName = fullName;
        this.birthYear = birthYear;
        this.className = className;
        this.sex = sex;
        this.averageGrade = averageGrade;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return code == student.code && Double.compare(student.averageGrade, averageGrade) == 0 && fullName.equals(student.fullName) && birthYear.equals(student.birthYear) && className.equals(student.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, fullName, birthYear, className, averageGrade);
    }

    @Override
    public int compareTo(Student o) {
        return (int) (this.getAverageGrade() - o.getAverageGrade());
    }

    @Override
    public String toString() {
        return "Student [code=" + code + ", fullName=" + fullName + ", birthYear=" + birthYear + ", className="
                + className + ", averageGrade=" + averageGrade + "]";
    }

    public String getInform() {
        return this.code + "," + this.fullName + "," + this.birthYear + "," + this.className + "," + this.sex + "," + this.averageGrade;
    }
}

