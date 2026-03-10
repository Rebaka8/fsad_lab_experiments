package com.example.courseapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.courseapi.model.Course;

@RestController

@RequestMapping("/courses")
public class CourseController {

    private List<Course> courseList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        courseList.add(course);
        return ResponseEntity.status(201).body(course);
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseList;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course course) {
        for (Course c : courseList) {
            if (c.getCourseId() == id) {
                c.setTitle(course.getTitle());
                c.setDuration(course.getDuration());
                c.setFee(course.getFee());
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(404).body("Course not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        courseList.removeIf(c -> c.getCourseId() == id);
        return ResponseEntity.ok("Course deleted successfully");
    }

    // SEARCH API
    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchCourse(@PathVariable String title) {

        List<Course> result = new ArrayList<>();

        for (Course c : courseList) {
            if (c.getTitle().equalsIgnoreCase(title)) {
                result.add(c);
            }
        }

        if (result.isEmpty()) {
            return ResponseEntity.status(404).body("Course not found");
        }

        return ResponseEntity.ok(result);
    }
}