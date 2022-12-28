package util;

import model.Student;
import view.StudentView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static void writeFile(String path, List<Student> studentList) {
        try {
            File file = new File(path);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Student student :
                    studentList) {
                bufferedWriter.write(student.getInfo());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readFile(String path) {
        List<Student> studentList = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            String[] array;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Student student = new Student(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4], Double.parseDouble(array[5]));
                studentList.add(student);
            }
        } catch (Exception e) {
            StudentView.errorPath();
            e.printStackTrace();
        }
        return studentList;
    }
}
