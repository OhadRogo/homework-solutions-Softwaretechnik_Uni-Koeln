package src.HM03_Code;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{

    private List<Course> registeredCourses;

    public Student(String UserID, String firstName, String lastName, List<Course> registeredCourses) {
        super(UserID, firstName, lastName);
        this.registeredCourses = new ArrayList<>();
    }
    public void registerCourse(Course course){
        registeredCourses.add(course);
    }

}
