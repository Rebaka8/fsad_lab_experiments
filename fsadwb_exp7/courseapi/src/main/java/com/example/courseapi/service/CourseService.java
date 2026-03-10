package com.example.courseapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.courseapi.model.Course;

@Service
public class CourseService {

    private List<Course> courseList = new ArrayList<>();

    // Add course
    public Course addCourse(Course course) {
        courseList.add(course);
        return course;
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseList;
    }

    // Update course
    public Course updateCourse(int id, Course updatedCourse) {

        for (Course c : courseList) {
            if (c.getCourseId() == id) {
                c.setTitle(updatedCourse.getTitle());
                c.setDuration(updatedCourse.getDuration());
                c.setFee(updatedCourse.getFee());
                return c;
            }
        }

        return null;
    }

    // Delete course
    public boolean deleteCourse(int id) {

        for (Course c : courseList) {
            if (c.getCourseId() == id) {
                courseList.remove(c);
                return true;
            }
        }

        return false;
    }

    // Search course by title
    public List<Course> searchByTitle(String title) {

        List<Course> result = new ArrayList<>();

        for (Course c : courseList) {
            if (c.getTitle().equalsIgnoreCase(title)) {
                result.add(c);
            }
        }

        return result;
    }
}