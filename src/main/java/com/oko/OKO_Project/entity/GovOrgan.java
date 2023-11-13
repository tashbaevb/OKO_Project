package com.oko.OKO_Project.entity;

import com.oko.OKO_Project.enums.GovOrgansType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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

    String title, text;

    @Enumerated(EnumType.STRING)
    GovOrgansType govOrgansType;
}
