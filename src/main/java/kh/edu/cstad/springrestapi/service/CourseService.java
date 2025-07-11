package kh.edu.cstad.springrestapi.service;

import kh.edu.cstad.springrestapi.dto.CourseRequest;
import kh.edu.cstad.springrestapi.dto.CourseResponse;

import java.util.List;

public interface CourseService {

    /**
     * Get All Courses
     * @return List of CourseResponse
     * @autor lyheang
     */
//    get all course, status, title
//    /courses, /course?status=true, /course?title=web, /course?status=true&title=web
    List<CourseResponse> getCourses();


    /**
     * បង្កើតមេរៀនថ្មី
     * @param courseRequest
     * @return CourseResponse
     */
    CourseResponse createCourse(CourseRequest courseRequest);


    void deleteCourse(String code);


}
