package com.Aptcoder.Assignment.Service;

import com.Aptcoder.Assignment.repo.CourseRepository;
import com.Aptcoder.Assignment.Domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
@Transactional

public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        Course cot = new Course();
        cot.setName(course.getName());
        cot.setSubject(course.getSubject());
        cot.setChapters(course.getChapters());
        cot.setNumberOfClasses(course.getNumberOfClasses());
        cot.setType(course.getType());
        cot.setLearnMode(course.getLearnMode());

        return  courseRepository.save(cot);

    }

    public Course updateCourse(Long id, Course course) {
        Course existingCourse = this.courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        existingCourse.setName(course.getName());
        existingCourse.setSubject(course.getSubject());
        existingCourse.setChapters(course.getChapters());
        existingCourse.setNumberOfClasses(course.getNumberOfClasses());
        existingCourse.setType(course.getType());
        existingCourse.setLearnMode(course.getLearnMode());


        return courseRepository.save(existingCourse) ;
    }

    public Object getCourse(Long id, String userRole) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if (userRole.equals("student")) {
            return new CourseDetailsDTO(course.getName(), course.getSubject());
        } else {
            return course;
        }
    }

    private static class CourseDetailsDTO {
        private final String name;
        private final String subject;

        public CourseDetailsDTO(String name, String subject) {
            this.name = name;
            this.subject = subject;
        }

        public String getName() {
            return name;
        }

        public String getSubject() {
            return subject;
        }
    }

    public  List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    public void deleteCourse (Course course){
        courseRepository.delete(course);
    }

}
