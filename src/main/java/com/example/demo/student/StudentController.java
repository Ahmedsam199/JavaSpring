package com.example.demo.student;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/Student")
    public List<Student> getStudent() {
        return studentService.getStudent();
    }
    @PostMapping("/Student")
    public Student saveStudent(@Valid @RequestBody Student student) {
        return studentService.createStudent(student);
    }

}
