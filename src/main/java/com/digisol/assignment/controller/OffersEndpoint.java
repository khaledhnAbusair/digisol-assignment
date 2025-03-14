package com.digisol.assignment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Slf4j
public class OffersEndpoint {

    private final String endpoint;

    public OffersEndpoint(@Value("${app.api.offers-endpoint}") String endpoint) {
        this.endpoint = endpoint;
    }

    @GetMapping
    public String index(Model model) {
        log.info("The offer endpoint is {}", endpoint);
        model.addAttribute("offersEndpoint", endpoint);
        return "index";
    }
}
