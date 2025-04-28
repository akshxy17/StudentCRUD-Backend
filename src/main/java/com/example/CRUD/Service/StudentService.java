package com.example.CRUD.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.CRUD.Entity.Student;
import com.example.CRUD.Repository.StudentRepo;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepo repo;

    public List<Student> getAllStudents() {
        List<Student> students = repo.findAll();
        return students;
    }

    public Student getStudentById(@PathVariable int id) {
        Student student = repo.findById(id).get();
        return student;
    }
    
    public void addStudent(@RequestBody Student student) {
        repo.save(student);
    }

    public void updateStudent(int id, Student student) {
        Student existingStudent = repo.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            repo.save(existingStudent);
        }
    }
    public void deleteStudent(@PathVariable int id) {
        Student student =  repo.findById(id).get();
        repo.delete(student);
    }
    
}
