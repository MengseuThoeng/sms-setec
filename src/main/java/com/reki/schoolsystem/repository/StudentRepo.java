package com.reki.schoolsystem.repository;

import com.reki.schoolsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
