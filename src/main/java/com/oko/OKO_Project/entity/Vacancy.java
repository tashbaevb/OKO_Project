package com.oko.OKO_Project.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CollectionId;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Vacancy")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String title;

    @Column
    String titleOne;

    @ElementCollection
    List<String> textOne = new ArrayList<>();

    @Column
    String titleTwo;

    @ElementCollection
    List<String> textTwo = new ArrayList<>();

    @Column
    String aboutTheJobTitle;

    @ElementCollection
    List<String> aboutTheJob = new ArrayList<>();

}
