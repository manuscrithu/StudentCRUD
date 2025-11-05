package com.example.StudentCRUDBackend.service;

import com.example.StudentCRUDBackend.exception.ResourceNotFoundException;
import com.example.StudentCRUDBackend.model.Student;
import com.example.StudentCRUDBackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        existing.setStName(student.getStName());
        existing.setEmail(student.getEmail());
        existing.setCourse(student.getCourse());
        existing.setAge(student.getAge());

        return studentRepository.save(existing);
    }

    @Override
    public void deleteStudent(Long id) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        studentRepository.delete(existing);
    }

    @Override
    public List<Student> searchStudents(String name, String course) {
        if (name != null && course != null) {
            return studentRepository.findByStNameContainingIgnoreCaseOrCourseContainingIgnoreCase(name, course);
        } else if (name != null) {
            return studentRepository.findByStNameContainingIgnoreCase(name);
        } else if (course != null) {
            return studentRepository.findByCourseContainingIgnoreCase(course);
        }
        return List.of(); // empty list if no criteria provided
    }
}
