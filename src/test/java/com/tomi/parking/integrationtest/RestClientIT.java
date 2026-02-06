package com.tomi.parking.integrationtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.web.client.RestClient;

@Tag("integration")
public class RestClientIT {

    private RestClient restClient;

    @BeforeEach
    public void setup() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    @Test
    public void get_inputIs30And20And10And15And5_theResultIs5() {
        int[] numbers = {30, 20, 10, 15, 5};

        int difference = restClient.get().uri("/minimumdifference?numbers={numbers}", numbers)
                .retrieve()
                .body(int.class);

        assertEquals(5, difference);
    }

    @Test
    public void post_inputIs5And15And10And20And30_theResultIs10() {
        int[] numbers = {5, 15, 100, 20, 30};

        int difference = restClient.post().uri("/minimumdifference").body(numbers)
                .retrieve()
                .body(int.class);

        assertEquals(10, difference);
    }
}
