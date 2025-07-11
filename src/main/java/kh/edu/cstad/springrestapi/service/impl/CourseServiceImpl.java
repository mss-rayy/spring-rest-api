package kh.edu.cstad.springrestapi.service.impl;

import kh.edu.cstad.springrestapi.domain.Course;
import kh.edu.cstad.springrestapi.dto.CourseRequest;
import kh.edu.cstad.springrestapi.dto.CourseResponse;
import kh.edu.cstad.springrestapi.repository.CourseRepository;
import kh.edu.cstad.springrestapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

//    1. define dependency
    private  final CourseRepository courseRepository;

    @Override
    public CourseResponse createCourse(CourseRequest courseRequest) {

//        array list, add()
        courseRepository
                .getCourses()
                .add(
                        Course.builder()
                                .uuid(UUID.randomUUID())
                                .code("B-03")
                                .title(courseRequest.title())
                                .description(courseRequest.description())
                                .price(courseRequest.price())
                                .status(false)
                                .build()
                );


//        return CourseResponse;
        return null;
    }

    @Override
    public List<CourseResponse> getCourses() {

        return courseRepository.getCourses().stream().map(course -> CourseResponse.builder()
                .code(course.getCode())
                .title(course.getTitle())
                .description(course.getDescription())
                .price(course.getPrice())
                .status(course.getStatus())
                .build())
                .toList();

    }
}
