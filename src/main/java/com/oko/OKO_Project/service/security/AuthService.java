package com.oko.OKO_Project.service.security;


import com.oko.OKO_Project.entity.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

public interface AuthService {

    void register(User registrationRequest);

    boolean isPresentEmail(String email);

    @Transactional(isolation = Isolation.SERIALIZABLE)
    String resetPassword(String email);

    @Transactional(isolation = Isolation.SERIALIZABLE)
    String saveNewPassword(String resetToken, String newPassword);
}
