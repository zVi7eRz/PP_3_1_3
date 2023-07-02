package ru.kata.spring.boot_security.demo.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Should return null when the username does not exist")
    void findByUsernameWhenUsernameDoesNotExist() {
        String username = "nonexistentuser";
        when(userRepository.findByUsername(username)).thenReturn(null);

        User result = userService.findByUsername(username);

        assertNull(result);
        verify(userRepository, times(1)).findByUsername(username);
    }

    @Test
    @DisplayName("Should return the user when the username exists")
    void findByUsernameWhenUsernameExists() {
        String username = "john.doe";
        User user = new User();
        user.setUsername(username);

        when(userRepository.findByUsername(username)).thenReturn(user);

        User result = userService.findByUsername(username);

        assertEquals(user, result);
        verify(userRepository, times(1)).findByUsername(username);
    }

}

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Should return null when the username does not exist")
    void findByUsernameWhenUsernameDoesNotExist() {
        String username = "nonexistentuser";
        when(userRepository.findByUsername(username)).thenReturn(null);

        User result = userService.findByUsername(username);

        assertNull(result);
        verify(userRepository, times(1)).findByUsername(username);
    }

    @Test
    @DisplayName("Should return the user when the username exists")
    void findByUsernameWhenUsernameExists() {
        String username = "john.doe";
        User user = new User();
        user.setUsername(username);

        when(userRepository.findByUsername(username)).thenReturn(user);

        User result = userService.findByUsername(username);

        assertEquals(user, result);
        verify(userRepository, times(1)).findByUsername(username);
    }

}