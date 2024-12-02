package src.homeworkCodes;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getUserID().equals(id)) {
                return student;
            }
        }
        return null; // gibt null zurück, falls kein Student mit der angegebenen ID gefunden
    }

    public List<Student> getAllStudents() {
        return students;
    }


}
