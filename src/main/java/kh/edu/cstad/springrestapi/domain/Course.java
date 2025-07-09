package kh.edu.cstad.springrestapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Integer id;
    private String title;
    private String description;
    private Double price;
    private Boolean status;
}
