package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
@Service
public interface UserService extends UserDetailsService {
    List<String> getAllUsername();
    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUser(Long userId);
    User show(Long id);

}
