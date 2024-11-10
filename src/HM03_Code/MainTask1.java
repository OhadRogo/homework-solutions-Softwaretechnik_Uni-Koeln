package src.HM03_Code;

public class MainTask1 {
    public static void main(String[] args) {
        // Example Usage
        Student student1 = new Student("S001", "Alice", "Smith");
        Lecturer lecturer1 = new Lecturer("L001", "Dr. John", "Doe");
        Course course1 = new Lecture("C001", "Software Engineering");
        Course course2 = new Lecture("C002", "IIS");

        student1.registerCourse(course1);
        student1.registerCourse(course2);

        lecturer1.manageCourse(course1);
        System.out.println(student1.getRegisteredCourses().size());

    }

}
