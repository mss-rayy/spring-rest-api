package kh.edu.cstad.springrestapi.controller;

import kh.edu.cstad.springrestapi.domain.Course;
import kh.edu.cstad.springrestapi.dto.CourseResponse;
import kh.edu.cstad.springrestapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

//    need service bean
    private final CourseService courseService;

//    get all courses

    @GetMapping()
    @ResponseBody
    public List<CourseResponse> getCourses(@RequestParam(required = false, defaultValue = "true") Boolean status){

       return courseService.getCourses(status);
    }
}
