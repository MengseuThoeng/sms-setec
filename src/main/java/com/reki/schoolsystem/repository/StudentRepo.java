package com.reki.schoolsystem.repository;

import com.reki.schoolsystem.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    private List<Student> students = new ArrayList<>();

    public StudentRepo() {
        students.add(new Student(1L, "Jose", "Masculino", "<EMAIL>", 10));
        students.add(new Student(2L, "Maria", "Feminino", "<EMAIL>", 9));
        students.add(new Student(3L, "João", "Masculino", "<EMAIL>", 8));
        students.add(new Student(4L, "Pedro", "Masculino", "<EMAIL>", 7));
        students.add(new Student(5L, "Ana", "Feminino", "<EMAIL>", 6));
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findById(Long id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public void save(Student student) {
        students.add(student);
    }

    public void delete(Long id) {
        students.removeIf(s -> s.getId().equals(id));
    }

    public void update(Student student, Long id) {
        students.set(Math.toIntExact(id-1),student);
    }

    public boolean existsById(Long id) {
        return students.stream().anyMatch(s -> s.getId().equals(id));
    }


}
