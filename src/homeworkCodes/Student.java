package src.homeworkCodes;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{

    private List<Course> registeredCourses;

    public Student(String UserID, String firstName, String lastName) {
        super(UserID, firstName, lastName);
        this.registeredCourses = new ArrayList<>();
    }
    //register to Course
    public void registerCourse(Course course){
        registeredCourses.add(course);
    }

    //getters
    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }


}
