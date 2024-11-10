package src.HM03_Code;

import java.util.List;

public class MainTask2 {
    public static void main(String[] args) {

            // Create an instance of EntityManager for managing Student objects
            EntityManager<Student> studentManager = new EntityManager<>();

            // Create some students
            Student student1 = new Student("S001", "Alice", "Smith");
            Student student2 = new Student("S002", "Bob", "Brown");
            Student student3 = new Student("S003", "Charlie", "Davis");

            // Register courses for the students (assuming Course class is defined)
            Course course1 = new Course("C001", "Software Engineering");
            Course course2 = new Course("C002", "Data Structures");

            student1.registerCourse(course1);
            student2.registerCourse(course2);
            student3.registerCourse(course1);
            student3.registerCourse(course2);

            // Add students to the EntityManager
            studentManager.addEntity(student1);
            studentManager.addEntity(student2);
            studentManager.addEntity(student3);

            // Example: Find a student by userID
            Student foundStudent = studentManager.getEntityById("S001", student -> student.getUserID().equals("S001"));
            if (foundStudent != null) {
                System.out.println("Found Student: " + foundStudent.getFirstName() + " " + foundStudent.getLastName());
            } else {
                System.out.println("Student not found.");
            }

            // Example: Filter students who are registered for "Software Engineering"
            List<Student> softwareEngineeringStudents = studentManager.filterEntities(student ->
                    student.getRegisteredCourses().stream().anyMatch(course -> course.getCourseName().equals("Software Engineering"))
            );

            System.out.println("Students registered for Software Engineering: ");
            for (Student student : softwareEngineeringStudents) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        }
}
