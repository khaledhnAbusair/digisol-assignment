package com.digisol.assignment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "expedia", url = "${base.url}")
public interface ExpediaApiClient {

    @GetMapping("/offers/v2/getOffers")
    String getOffers(
            @RequestParam("scenario") String scenario,
            @RequestParam("page") String page,
            @RequestParam("uid") String uid,
            @RequestParam("productType") String productType,
            @RequestParam("clientId") String clientId,
            @RequestParam("originCity") String originCity,
            @RequestParam("destinationCity") String destinationCity
    );
}