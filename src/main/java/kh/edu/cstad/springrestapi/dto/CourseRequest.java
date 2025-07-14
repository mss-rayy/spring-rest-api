package kh.edu.cstad.springrestapi.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public record CourseRequest(

        @NotBlank(message = "Code is required and cannot be blank")
        String code,

        @NotBlank(message = "Title is required and cannot be blank")
        String title,
        String description,
        Double price
) { }
