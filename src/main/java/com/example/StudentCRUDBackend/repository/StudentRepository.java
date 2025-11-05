package com.example.StudentCRUDBackend.repository;

import com.example.StudentCRUDBackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Search by student name (case-insensitive partial match)
    List<Student> findByStNameContainingIgnoreCase(String stName);

    // Search by course (case-insensitive partial match)
    List<Student> findByCourseContainingIgnoreCase(String course);

    // Optional: combined search (name OR course)
    List<Student> findByStNameContainingIgnoreCaseOrCourseContainingIgnoreCase(String stName, String course);
}
