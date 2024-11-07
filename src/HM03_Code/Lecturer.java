package src.HM03_Code;

import java.util.ArrayList;
import java.util.List;

public class Lecturer extends User{

    private List<Course> managedCourses;

    public Lecturer(String userID, String firstName, String lastName) {
        super(userID, firstName, lastName);
        this.managedCourses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        managedCourses.add(course);
    }
}
