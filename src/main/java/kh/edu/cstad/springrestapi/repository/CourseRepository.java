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

    List<Course> courses;

    public CourseRepository(){
        courses = new ArrayList<>();

        courses.add(Course.builder()
                .uuid(UUID.randomUUID())
                .code("B-01")
                .title("Web Design")
                .description("Web Design description")
                .price(100.0)
                .status(true)
                .build());
        courses.add(Course.builder()
                .uuid(UUID.randomUUID())
                .code("B-02")
                .title("Spring Framework")
                .description("Spring Framework description")
                .price(150.0)
                .status(false)
                .build());
    }
}
