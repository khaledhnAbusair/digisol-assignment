package com.digisol.assignment.controller;

import com.digisol.assignment.client.ExpediaApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OfferControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @MockitoBean
    private ExpediaApiClient expediaApiClient;

    @Test
    void testGetOffers() {
        String originCity = "Seattle";
        String destinationCity = "New York";
        String mockResponse = "{\"offers\":{\"Package\":[{\"offerName\":\"Test Offer\",\"originCity\":\"Seattle\",\"destinationCity\":\"New York\",\"totalPrice\":{\"value\":500,\"currency\":\"USD\"}}]}}";

        when(expediaApiClient.getOffers("deal-finder", "foo", "test", "Package", "test", originCity, destinationCity))
                .thenReturn(mockResponse);

        ResponseEntity<String> response = restTemplate.getForEntity(
                "/api/offers?originCity={origin}&destinationCity={destination}",
                String.class,
                originCity,
                destinationCity
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }
}