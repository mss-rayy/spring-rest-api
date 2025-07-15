package kh.edu.cstad.springrestapi.service;

import kh.edu.cstad.springrestapi.domain.Course;
import kh.edu.cstad.springrestapi.dto.CourseRequest;
import kh.edu.cstad.springrestapi.dto.CourseResponse;

import java.util.List;

public interface CourseService {
    /**
     *  Get all courses
     * @author sreyphea
     * @return a list of CourseResponse objects
     *  */
    List<CourseResponse> getCourses(Boolean status, String title);

    CourseResponse addCourse(CourseRequest courseRequest);

    CourseResponse getCourseByCode(String code);

    void deleteCourseByCode(String code);

}
