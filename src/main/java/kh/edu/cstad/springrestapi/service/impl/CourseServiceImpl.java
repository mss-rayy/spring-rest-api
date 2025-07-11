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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<CourseResponse> getCourses(Boolean status, String title) {

        List<CourseResponse> findCourses = courseRepository.getCourses()
                .stream()
                .filter(course -> {
                    if(status != null) {
                        return course.getStatus().equals(status);
                    }
                    return true;
                })
                .filter(course -> {
                    if(title != null) {
                        return course.getTitle().toLowerCase().contains(title.toLowerCase());
                    }
                    return true;
                })
                .map(course -> CourseResponse.builder()
                        .code(course.getCode())
                        .title(course.getTitle())
                        .description(course.getDescription())
                        .price(course.getPrice())
                        .status(course.getStatus())
                        .build()).toList();

        if (findCourses.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course with title " +  title +" NOT FOUND");
        }

        return  findCourses;
    }

    @Override
    public CourseResponse addCourse(CourseRequest courseRequest) {

//      Check code
        boolean isCourseExisted = courseRepository.getCourses()
                .stream()
                .anyMatch(course -> course.getCode().equalsIgnoreCase(courseRequest.code()));


//        validate of course existed
        if (isCourseExisted) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Course code already exists");
        }

//        add courseRequest to Course
        Course course = Course.builder()
                        .id(UUID.randomUUID())
                        .code(courseRequest.code())
                        .title(courseRequest.title())
                        .description(courseRequest.description())
                        .price(courseRequest.price())
                        .status(false)
                        .build();

        courseRepository.getCourses().add(course);
//        map course to courseResponse

        return CourseResponse.builder()
                .code(course.getCode())
                .title(course.getTitle())
                .description(course.getDescription())
                .price(course.getPrice())
                .status(false)
                .build();
    }

    @Override
    public CourseResponse getCourseByCode(String code) {

        return courseRepository.getCourses().stream()
                .filter(course -> course.getCode().equalsIgnoreCase(code))
                .map(course -> CourseResponse.builder()
                        .code(course.getCode())
                        .title(course.getTitle())
                        .description(course.getDescription())
                        .price(course.getPrice())
                        .status(course.getStatus())
                        .build()
                ).findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    }

    @Override
    public void deleteCourseByCode(String code) {

//        check code exist or not
         boolean isRemoved = courseRepository.getCourses()
                .removeIf(course -> course.getCode().equalsIgnoreCase(code));

         if (!isRemoved) {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
         }

    }


}
