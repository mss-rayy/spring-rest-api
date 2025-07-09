package kh.edu.cstad.springrestapi.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CourseResponse(
        String code,
        String title,
        String description,
        Double price,
        Boolean status
) {
}
