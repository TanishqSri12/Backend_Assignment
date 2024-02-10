package com.Aptcoder.Assignment.controller;

import com.Aptcoder.Assignment.Domain.Course;
import com.Aptcoder.Assignment.Service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService ;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Course updatedCourse = courseService.updateCourse(id, course);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getCourse(@PathVariable Long id, @RequestHeader("user-role") String userRole) {

        try {
            Object course = courseService.getCourse(id, userRole);
            return new ResponseEntity<>(course, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @PostMapping("/create")
//    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
//        return courseService.createCourse(course);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
//        return courseService.updateCourse(id, course);
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
//        return courseService.getCourse(id);
//    }
}
