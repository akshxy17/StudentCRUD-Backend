package com.example.CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUD.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    
}
