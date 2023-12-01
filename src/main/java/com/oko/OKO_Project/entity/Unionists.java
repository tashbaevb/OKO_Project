package com.oko.OKO_Project.entity;

import com.oko.OKO_Project.enums.UnionistsType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "union_members")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Unionists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title, text;

    @ElementCollection
    List<String> description = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    UnionistsType unionistsType;
}
