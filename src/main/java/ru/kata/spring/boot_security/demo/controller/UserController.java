package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
public class UserController {
    private final UserService userService;
    private final RoleRepository roleRepository;

    public UserController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/admin")
    public String index(ModelMap model) {
        model.addAttribute("users", userService.allUsers());
        return "admin";
    }

    @GetMapping("/user/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    @GetMapping("/admin/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping(value = "/admin")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/user/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model, Authentication authentication) {
        model.addAttribute("authorization", authentication);
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PatchMapping("/user/{id}")
    public String updateUser(@ModelAttribute("users") User user) {
        userService.saveUser(user);
        return "redirect:/user/{id}";

    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/user/{id}";
    }
}