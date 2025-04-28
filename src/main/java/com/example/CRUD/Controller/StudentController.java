package com.example.CRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.CRUD.Entity.Student;
import com.example.CRUD.Service.StudentService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/")
public class StudentController {
     
    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @PostMapping("/students/add")
    public void addStudent(@RequestBody Student student) {
        service.addStudent(student);
        
    }

    @PutMapping("/students/update/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student student) {
        service.updateStudent(id, student);
        
    }

    @DeleteMapping("/students/delete/{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);        
    }

    
}
