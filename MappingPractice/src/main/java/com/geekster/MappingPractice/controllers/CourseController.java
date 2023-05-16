package com.geekster.MappingPractice.controllers;

import com.geekster.MappingPractice.models.Course;
import com.geekster.MappingPractice.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/")
    public String addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("byTitle/{title}")
    public List<Course> getCoursesBasedOnTitle(@PathVariable String title) {
        return courseService.getCoursesBasedOnTitle(title);
    }

    @DeleteMapping("/byDuration/{duration}")
    public void removeCourseByDuration(@PathVariable String duration) {
        courseService.removeCourseByDuration(duration);
    }

    @PutMapping("/byId/{id}/title/{title}")
    public String updateTitleBasedOnId(@PathVariable Long id,@PathVariable String title) {
        return courseService.updateTitleBasedOnId(id,title);
    }
}
