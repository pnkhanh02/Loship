package com.vti.loshipBE.services;

import com.vti.loshipBE.jwt.JWTUtility;
import com.vti.loshipBE.models.User;
import com.vti.loshipBE.repositories.UserRepository;
import com.vti.loshipBE.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public String loginWithEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);
        assert user != null;
        if (PasswordEncoder.getInstance().matches(password, user.getPassword())) {
            return JWTUtility.getInstance().generateTokenWithEmail(email);
        }
        return null;
    }
}
