package com.cjc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.app.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
