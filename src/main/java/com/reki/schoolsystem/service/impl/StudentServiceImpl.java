package com.reki.schoolsystem.service.impl;

import com.reki.schoolsystem.dto.StudentUpdateRequest;
import com.reki.schoolsystem.model.Student;
import com.reki.schoolsystem.repository.StudentRepo;
import com.reki.schoolsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepo.findById(id);
    }

    @Override
    public void save(Student student) {
        if (studentRepo.existsById(student.getId())) {
            throw new RuntimeException("StudentID already exists");
        }
        studentRepo.save(student);
    }

    @Override
    public void delete(Long id) {
        if (!studentRepo.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
        studentRepo.delete(id);
    }

    @Override
    public void update(StudentUpdateRequest studentUpdateRequest, Long id) {

        if (!studentRepo.existsById(id)) {
            throw new RuntimeException("Student not found");
        }

        if (Stream.of(
                studentUpdateRequest.name(),
                studentUpdateRequest.email(),
                studentUpdateRequest.sex(),
                studentUpdateRequest.score()
        ).anyMatch(Objects::isNull)) {
            throw new RuntimeException("All fields are required");
        }

        Student student = new Student();
        student.setId(id);
        student.setName(studentUpdateRequest.name());
        student.setEmail(studentUpdateRequest.email());
        student.setSex(studentUpdateRequest.sex());
        student.setScore(studentUpdateRequest.score());
        studentRepo.update(student, id);
    }


}
