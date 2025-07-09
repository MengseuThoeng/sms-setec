package com.reki.schoolsystem.controller;


import com.reki.schoolsystem.dto.StudentUpdateRequest;
import com.reki.schoolsystem.model.Student;
import com.reki.schoolsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping("/{id}")
    Student findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void save(@RequestBody Student student){
        studentService.save(student);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        studentService.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody StudentUpdateRequest studentUpdateRequest, @PathVariable Long id){
        studentService.update(studentUpdateRequest, id);
    }
}
