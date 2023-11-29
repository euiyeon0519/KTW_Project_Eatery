package com.example.ktw_project_eatery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainPage() {
        return "mainPage";
    }

//    @GetMapping("/stay")
//    public String stayPage() {
//
//        return "stayPage";
//    }

    @GetMapping("/eatery")
    public String eateryPage() {

        return "eateryPage";
    }

}
