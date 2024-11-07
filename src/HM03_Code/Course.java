package src.HM03_Code;

public class Course {
    private String courseID;
    private String courseName;

    public Course(String courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
    }
    //getters
    public String getCourseID() {
        return courseID;
    }
    public String getCourseName() {
        return courseName;
    }
}
