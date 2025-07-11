package kh.edu.cstad.springrestapi.dto;

public record CourseRequest(
        String code,
        String title,
        String description,
        Double price
) { }
