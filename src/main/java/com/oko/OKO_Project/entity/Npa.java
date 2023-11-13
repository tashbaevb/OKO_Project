package com.oko.OKO_Project.entity;

import com.oko.OKO_Project.enums.NpaType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "npa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Npa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title, text;

    @Enumerated(EnumType.STRING)
    NpaType npaType;
}
