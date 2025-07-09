package kh.edu.cstad.springrestapi.service.impl;

import kh.edu.cstad.springrestapi.domain.Course;
import kh.edu.cstad.springrestapi.dto.CourseResponse;
import kh.edu.cstad.springrestapi.repository.CourseRepository;
import kh.edu.cstad.springrestapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<CourseResponse> getCourses(Boolean status) {

        return courseRepository.getCourses().stream().filter(course -> course.getStatus() == status).map(course -> CourseResponse.builder()
                .code(course.getCode())
                .title(course.getTitle())
                .description(course.getDescription())
                .price(course.getPrice())
                .status(course.getStatus())
                .build()).toList();
    }
}
