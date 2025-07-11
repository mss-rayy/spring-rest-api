package kh.edu.cstad.springrestapi.controller;

import kh.edu.cstad.springrestapi.dto.CourseRequest;
import kh.edu.cstad.springrestapi.dto.CourseResponse;
import kh.edu.cstad.springrestapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {

//    1. define dependency
    private final CourseService courseService;

    @GetMapping()
    public List<CourseResponse> getCourses(){

        return courseService.getCourses();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED) // 201
    public CourseResponse createCourse(@RequestBody CourseRequest courseRequest){

        return courseService.createCourse(courseRequest);
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable String code){
        courseService.deleteCourse(code);
    }
}
