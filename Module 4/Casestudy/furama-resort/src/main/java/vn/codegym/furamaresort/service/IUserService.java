package vn.codegym.furamaresort.service;

import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.user.User;

import java.util.Optional;

@Service
public interface IUserService {
    Optional<User> getUserByUsername(String username);

    User saveUser(User user);

    boolean checkLogin(User user);
}