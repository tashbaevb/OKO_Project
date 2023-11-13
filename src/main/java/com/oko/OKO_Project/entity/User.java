package com.oko.OKO_Project.entity;

import com.oko.OKO_Project.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    Long id;

    String email, password;

    @Enumerated(EnumType.STRING)
    Role role;

    @Column(name = "reset_token")
    String resetToken;

    @Column(name = "reset_token_expire_time")
    LocalDateTime resetTokenExpireTime;

//    @Column(name = "refresh_token")
//    String refreshToken;
//
//    @Column(name = "refresh_token_expire_time")
//    LocalDateTime refreshTokenExpireTime;
}
