package com.wangzehao.currencyexchangeservice;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/circuit-break-api")
    @Retry(name="sample-api", fallbackMethod = "fallbackResponse")
    public String circuitBreakerApi(){
        logger.info("circuitBreakerApi received");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://127.0.0.1:8000/", String.class);
        return forEntity.getBody();
    }

    public String fallbackResponse(){
        return "fall-back-response";
    }
}
