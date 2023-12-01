package com.oko.OKO_Project.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Registry")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Registry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String title;

    @ElementCollection
    List<String> titleArray = new ArrayList<>();

    @ElementCollection
    List<String> text = new ArrayList<>();

    @ElementCollection
    List<String> description = new ArrayList<>();
}
