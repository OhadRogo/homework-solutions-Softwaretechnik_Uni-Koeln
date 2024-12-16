package com.example.homework_7;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;

public interface StudentRepository extends JpaRepository <Student, Long> {
    List<Student> findByName(String name);
    Student findByMatNr(String matNr);

}
