package com.oko.OKO_Project.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aboutus")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AboutUs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String titleOne;

    @Column
    String titleTwo;

    @ElementCollection
    List<String> Goals = new ArrayList<>();

    @ElementCollection
    List<String> descriptionOne = new ArrayList<>();

    @ElementCollection
    List<String> descriptionTwo = new ArrayList<>();

    @ElementCollection
    List<String> textArray = new ArrayList<>();

}
