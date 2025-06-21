package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class StudentService {
    private final StudentRepositry studentRepositry;
@Autowired
    public StudentService(StudentRepositry studentRepositry) {
        this.studentRepositry = studentRepositry;
    }
//List.of(
//        new Student(
//                        1L,
//                                "Mar",
//                        LocalDate.of(2000, Month.JANUARY, 22),
//                        22,
//                                "Test@gmail.com"
//                                )
//                                );
    public List<Student> getStudent() {

        return studentRepositry.findAll();
    }
    public Student createStudent(Student student) {
        return studentRepositry.save(student);
    }

}
