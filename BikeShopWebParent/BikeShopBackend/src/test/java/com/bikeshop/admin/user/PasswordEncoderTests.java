package com.bikeshop.admin.user;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTests {

    @Test
    public void testEncodePassword() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "wocdotcode2024";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        System.out.println(encodedPassword);

    }
}
