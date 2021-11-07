package vn.codegym.furamaresort.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;

class UserServiceTest {

    UserService userService = new UserService();

    @Test
    void loadUserByUsername() {
        UserDetails userDetails = userService.loadUserByUsername("baothanhbui");

        System.out.println(userDetails.getAuthorities().toArray());

        
    }
}