package vn.codegym.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.user.Role;
import vn.codegym.furamaresort.model.user.User;
import vn.codegym.furamaresort.repository.UserRepository;
import vn.codegym.furamaresort.service.IUserService;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements IUserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findById(username);
    }

    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public boolean checkLogin(User user) {
        Optional<User> userOptional = getUserByUsername(user.getUsername());

        return userOptional.map(u -> u.getPassword().equals(user.getPassword())).orElse(false);

    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findById(username);

        return userOptional.map(user -> {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            for (Role role : user.getRole()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}