package com.geekster.MappingPractice.repositories;

import com.geekster.MappingPractice.models.Student;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface IStudentRepo extends ListCrudRepository<Student,Long> {


    Student findByPhoneNumber(String phoneNumber);

    List<Student> findByAddressZipcode(Integer zipcode);
}
