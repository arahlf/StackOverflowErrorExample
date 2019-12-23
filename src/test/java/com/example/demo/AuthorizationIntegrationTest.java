package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthorizationIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testFoo() {
        ResponseEntity<Void> response = restTemplate.exchange("/foo", HttpMethod.GET, null, Void.class);

        Assertions.assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    }

    @Test
    public void testBar() {
        ResponseEntity<Void> response = restTemplate.exchange("/bar", HttpMethod.GET, null, Void.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
