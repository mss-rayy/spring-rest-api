package kh.edu.cstad.springrestapi.service;

import kh.edu.cstad.springrestapi.domain.Course;
import kh.edu.cstad.springrestapi.dto.CourseResponse;

import java.util.List;

public interface CourseService {
//    get all course
    /**
     *  Get all courses
     * @author sreyphea
     * @return a list of CourseResponse objects
     *  */
    List<CourseResponse> getCourses(Boolean status);

//    get course by code
//    filter by status
//    create new course
//    deleted course by id
}
