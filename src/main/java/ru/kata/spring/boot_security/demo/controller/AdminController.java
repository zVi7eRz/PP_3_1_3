package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("index")
public class AdminController {
    private final UserService userService;
    private final RoleRepository roleRepository;

    @Autowired
    public AdminController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping
    public String index(@ModelAttribute("newUser") User newUser, Model model,
                        @AuthenticationPrincipal User curUser) {
        model.addAttribute("users", userService.allUsers());
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("curUser", curUser);
        return "index";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        if (!userService.allUsername().contains(user.getUsername())) {
            userService.saveUser(user);
        }
        return "redirect:/index";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/index";

    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/index";
    }
}
