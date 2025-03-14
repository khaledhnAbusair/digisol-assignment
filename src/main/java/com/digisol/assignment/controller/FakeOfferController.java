package com.digisol.assignment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class FakeOfferController {

    @GetMapping(value = "/fake-offers", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> getOffers(@RequestParam String originCity, @RequestParam String destinationCity) {
        log.info("Get fake offers from origin city {} and destination city {}", originCity, destinationCity);

        Map<String, Object> response = new HashMap<>();
        List<Map<String, Object>> offers = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Map<String, Object> offer = new HashMap<>();
            offer.put("offerName", "Test Offer " + i);
            offer.put("originCity", originCity);
            offer.put("destinationCity", destinationCity);
            int price = 500 + (i * 50);
            offer.put("totalPrice", Map.of("value", price, "currency", "USD"));
            offers.add(offer);
        }
        response.put("offers", Map.of("Package", offers));
        return response;

    }
}