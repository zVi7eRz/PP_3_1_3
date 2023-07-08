package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
@Service
public interface UserService extends UserDetailsService {
    List<String> allUsername();
    List<User> allUsers();
    void saveUser(User user);
    void deleteUser(Long userId);

}
