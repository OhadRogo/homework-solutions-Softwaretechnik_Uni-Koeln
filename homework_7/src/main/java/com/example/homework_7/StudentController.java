package com.example.homework_7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")

public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Get a student by ID.
     * @param id The ID of the student to retrieve.
     * @return The student object or a 404 error if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Create a new student.
     * @param student The student data to save.
     * @return The saved student object.
     */
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    /**
     * Delete a student by ID.v
     * @param id The ID of the student to delete.
     * @return A response entity indicating the outcome (success or failure).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
