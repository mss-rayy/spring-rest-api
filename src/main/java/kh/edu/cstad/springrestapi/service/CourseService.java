package kh.edu.cstad.springrestapi.service;

import kh.edu.cstad.springrestapi.dto.CourseRequest;
import kh.edu.cstad.springrestapi.dto.CourseResponse;

import java.util.List;

public interface CourseService {
//    get courses ?status="false"
    List<CourseResponse> getCourses();

    CourseResponse createCourse(CourseRequest courseRequest);

//   courses?status="true"&title="spring"
//    List<CourseResponse> getCourses(String status, String title);

//  Get course by code
//    CourseResponse getCourseByCode(String code);

}
