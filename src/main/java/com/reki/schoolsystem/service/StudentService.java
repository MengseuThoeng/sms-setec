package com.reki.schoolsystem.service;

import com.reki.schoolsystem.dto.StudentUpdateRequest;
import com.reki.schoolsystem.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAllStudents();

    Student findById(Long id);

    void save(Student student);

    void delete(Long id);

    void update(StudentUpdateRequest studentUpdateRequest, Long id);

}
