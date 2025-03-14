package com.digisol.assignment.controller;

import com.digisol.assignment.client.ExpediaApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class OfferController {

    private final ExpediaApiClient expediaApiClient;

    public OfferController(ExpediaApiClient expediaApiClient) {
        this.expediaApiClient = expediaApiClient;
    }


    @GetMapping("/offers")
    public String getOffers(@RequestParam String originCity, @RequestParam String destinationCity) {
        log.info("Get offers from origin city {} and destination city {}", originCity, destinationCity);
        return expediaApiClient.getOffers("deal-finder", "foo", "test", "Package", "test", originCity, destinationCity);
    }
}