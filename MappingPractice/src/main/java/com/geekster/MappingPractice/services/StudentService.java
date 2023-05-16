package com.geekster.MappingPractice.services;

import com.geekster.MappingPractice.models.Address;
import com.geekster.MappingPractice.models.Student;
import com.geekster.MappingPractice.repositories.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    IStudentRepo iStudentRepo;

    public String addStudent(Student student) {

        Student isAdded = iStudentRepo.save(student);

        if(isAdded != null){
            return "Added student successfully..!!!";
        }
        return "failed to add..!!!";
    }


    public List<Student> getAllStudent() {
        return iStudentRepo.findAll();
    }

    public void removeStudentById(Long id) {
        iStudentRepo.deleteById(id);
    }

    public String updateAddressByPhoneNumber(String phoneNumber,Address address) {
        Student student = iStudentRepo.findByPhoneNumber(phoneNumber);
        if(student == null){
            return "phone number does not exist";
        }
        student.setAddress(address);
        iStudentRepo.save(student);
        return "updated address succesfully for this phone number "+phoneNumber;
    }

    public List<Student> getStudentsBasedOnZipcode(Integer zipcode) {

        List<Student> studentList = iStudentRepo.findByAddressZipcode(zipcode);
        return studentList;
    }
}
