package kh.edu.cstad.springrestapi.service.impl;

import kh.edu.cstad.springrestapi.domain.Course;
import kh.edu.cstad.springrestapi.dto.CourseRequest;
import kh.edu.cstad.springrestapi.dto.CourseResponse;
import kh.edu.cstad.springrestapi.repository.CourseRepository;
import kh.edu.cstad.springrestapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    //    1. define dependency
    private final CourseRepository courseRepository;

    @Override
    public CourseResponse createCourse(CourseRequest courseRequest) {
//       1. check course code

        boolean isCourseExisted = courseRepository.getCourses()
                .stream()
                .anyMatch(course -> course.getCode().equalsIgnoreCase(courseRequest.code()));

        if (isCourseExisted) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Course code already existed");
        }

//      2. map data from course request to domain model
        Course course = Course.builder()
                .uuid(UUID.randomUUID())
                .code(courseRequest.code())
                .title(courseRequest.title())
                .description(courseRequest.description())
                .price(courseRequest.price())
                .status(false)
                .build();

        courseRepository.getCourses().add(course);

//      3.map data domain model to course response

        return CourseResponse.builder()
                .code(course.getCode())
                .title(course.getTitle())
                .description(course.getDescription())
                .price(course.getPrice())
                .status(course.getStatus())
                .build();
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


    @Override
    public void deleteCourse(String code) {

        boolean isCourseExisted = courseRepository.getCourses()
                .removeIf(course -> course.getCode().equalsIgnoreCase(code));

        if (!isCourseExisted) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found!!");
        }

    }
}
