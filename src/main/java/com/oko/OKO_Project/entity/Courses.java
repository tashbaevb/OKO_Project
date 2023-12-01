package com.oko.OKO_Project.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String titleOne;

    @ElementCollection
    List<String> textOne = new ArrayList<>();

    @Column
    String titleTwo;

    @ElementCollection
    List<String> textTwo = new ArrayList<>();

    @Column
    String aboutTheCourseTitle;

    @ElementCollection
    List<String> aboutTheCourse = new ArrayList<>();

}
