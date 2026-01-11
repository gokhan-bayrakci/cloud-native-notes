package de.hskaiserslautern.cnns.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebController {
    @GetMapping("/")
    public String index() {
        return "index"; // templates/index.html search
    }
    
}
