package ru.kata.preproject.PP_3_1_2_BOOT.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.preproject.PP_3_1_2_BOOT.model.User;
import ru.kata.preproject.PP_3_1_2_BOOT.service.UserService;


@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController( UserService userService) {
        this.userService = userService;

    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "list-Users";
    }

    @GetMapping("/{id}")
    public String getOneUserByID(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getOneUser(id));
        return "user_page";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "create-User_page";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.addOneUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getOneUser(id));
        return "edit-user_page";
    }

    @PatchMapping("/{id}")
    public String saveEditedUser(@ModelAttribute("user") User user,
                                 @PathVariable(name = "id") int id) {
        userService.editUserDetails(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable(name = "id") int id) {
        userService.deleteUserByID(id);
        return "redirect:/users";
    }


}
