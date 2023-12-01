package com.oko.OKO_Project.entity;

import com.oko.OKO_Project.enums.NpaType;
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
public class Npa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    @ElementCollection
    List<String> titleArray = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    NpaType npaType;

    @ElementCollection
    List<String> descriptions = new ArrayList<>();
}
