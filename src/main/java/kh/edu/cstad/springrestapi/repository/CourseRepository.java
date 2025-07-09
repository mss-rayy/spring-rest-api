package kh.edu.cstad.springrestapi.repository;

import kh.edu.cstad.springrestapi.domain.Course;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Getter
public class CourseRepository {

    private List<Course> courses;

    CourseRepository(){
        courses = new ArrayList<>();
        courses.add(
                Course.builder()
                        .id(UUID.randomUUID())
                        .code("b-01")
                        .title("Course 1")
                        .description("Course 1 Description")
                        .price(100.0)
                        .status(true)
                        .build()
        );
        courses.add(
                Course.builder()
                        .id(UUID.randomUUID())
                        .code("b-02")
                        .title("Course 2")
                        .description("Course 2 Description")
                        .price(50.0)
                        .status(false)
                        .build()
        );
    }


}
