package com.oko.OKO_Project.entity;

import com.oko.OKO_Project.enums.GovOrgansType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Regulatory_organs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GovOrgan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ElementCollection
    List<String> title = new ArrayList<>();

    @ElementCollection
    List<String> descriptions = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    GovOrgansType govOrgansType;
}
