package ru.kata.preproject.PP_3_1_2_BOOT.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

    @RequestMapping("/")
    public String startPage() {
        return "redirect:/users";
    }
}
