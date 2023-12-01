package com.oko.OKO_Project.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "News")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String title;

    @Column
    String imgUrl;

    @ElementCollection
    List<String> text = new ArrayList<>();

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    Date date;
}
