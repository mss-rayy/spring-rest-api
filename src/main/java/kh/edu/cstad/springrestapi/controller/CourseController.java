package kh.edu.cstad.springrestapi.controller;

import jakarta.validation.Valid;
import kh.edu.cstad.springrestapi.dto.CourseRequest;
import kh.edu.cstad.springrestapi.dto.CourseResponse;
import kh.edu.cstad.springrestapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping()
    public List<CourseResponse> getCourses(@RequestParam(required = false) Boolean status, @RequestParam(required = false) String title){
       return courseService.getCourses(status, title);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse addCourse(@Valid @RequestBody CourseRequest courseRequest){
        return courseService.addCourse(courseRequest);
    }

    @GetMapping("/{code}")
    public CourseResponse getCourseByCode(@PathVariable String code){
        return courseService.getCourseByCode(code);
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourseByCode(@PathVariable String code){
        courseService.deleteCourseByCode(code);
    }

}
