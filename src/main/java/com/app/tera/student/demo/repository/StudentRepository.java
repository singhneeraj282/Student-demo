package com.app.tera.student.demo.repository;

import com.app.tera.student.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByRollNumber(Long rollNumber);
    Optional<Student> deleteByRollNumber(Long rollNumber);
}
