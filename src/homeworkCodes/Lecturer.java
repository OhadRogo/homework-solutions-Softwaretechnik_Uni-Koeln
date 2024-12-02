package src.homeworkCodes;

import java.util.ArrayList;
import java.util.List;

public class Lecturer extends User{

    private List<Course> managedCourses;

    public Lecturer(String userID, String firstName, String lastName) {
        super(userID, firstName, lastName);
        this.managedCourses = new ArrayList<>();
    }
    //manage Course methode
    public void manageCourse(Course course) {
        managedCourses.add(course);
    }

    //getters
    public List<Course> getManagedCourses() {
        return managedCourses;
    }
}
