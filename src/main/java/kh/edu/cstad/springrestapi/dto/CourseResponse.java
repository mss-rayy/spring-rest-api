package kh.edu.cstad.springrestapi.dto;

import lombok.Builder;

@Builder
public record CourseResponse(
        String code,
        String title,
        String description,
        Double price,
        Boolean status
) {
}

// immutetable, method : getter, constructor equal(),hashcode(), toString
