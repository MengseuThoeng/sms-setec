package com.reki.schoolsystem.service.impl;

import com.reki.schoolsystem.dto.StudentCreateRequestion;
import com.reki.schoolsystem.dto.StudentUpdateRequest;
import com.reki.schoolsystem.model.Student;
import com.reki.schoolsystem.repository.StudentRepo;
import com.reki.schoolsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
        return studentRepo.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Student not found"
                )
        );
    }

    @Override
    public void save(StudentCreateRequestion studentCreateRequestion) {
        Student student = new Student();

        student.setName(studentCreateRequestion.name());
        student.setSex(studentCreateRequestion.sex());
        student.setEmail(studentCreateRequestion.email());
        student.setScore(studentCreateRequestion.score());

        studentRepo.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public void update(StudentUpdateRequest studentUpdateRequest, Long id) {
        Student student = findById(id);

        student.setName(studentUpdateRequest.name());
        student.setSex(studentUpdateRequest.sex());
        student.setEmail(studentUpdateRequest.email());
        student.setScore(studentUpdateRequest.score());

        studentRepo.save(student);
    }


}
