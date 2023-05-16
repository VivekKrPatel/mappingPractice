package com.geekster.MappingPractice.controllers;

import com.geekster.MappingPractice.models.Address;
import com.geekster.MappingPractice.models.Student;
import com.geekster.MappingPractice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/all")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("byZipcode/{zipcode}")
    public List<Student> getStudentsBasedOnZipcode(@PathVariable Integer zipcode) {
        return studentService.getStudentsBasedOnZipcode(zipcode);
    }

    @DeleteMapping("/byId/{id}")
    public void removeStudentById(@PathVariable Long id) {
        studentService.removeStudentById(id);
    }

    @PutMapping("/byPhoneNo/{phoneNumber}/updateAddress/{address}")
    public String updateAddressByPhoneNumber(@PathVariable String phoneNumber,@RequestBody Address address) {
        return studentService.updateAddressByPhoneNumber(phoneNumber,address);
    }
}
