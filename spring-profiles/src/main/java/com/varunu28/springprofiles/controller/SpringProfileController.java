package com.varunu28.springprofiles.controller;

import com.varunu28.springprofiles.service.SpringProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
public class SpringProfileController {

    private final SpringProfileService springProfileService;

    public SpringProfileController(SpringProfileService springProfileService) {
        this.springProfileService = springProfileService;
    }

    @GetMapping("/greeting")
    public String greeting() {
        return springProfileService.getGreeting();
    }

    @GetMapping("/default")
    public String defaultValue() {
        return springProfileService.getDefaultValue();
    }

    @GetMapping("/list")
    public String[] listValues() {
        return springProfileService.getListValues();
    }
}
