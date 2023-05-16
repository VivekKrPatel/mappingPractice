package com.geekster.MappingPractice.repositories;

import com.geekster.MappingPractice.models.Course;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ICourseRepo extends ListCrudRepository<Course,Long> {
    List<Course> findByTitle(String title);

    void deleteByDuration(String duration);
}
