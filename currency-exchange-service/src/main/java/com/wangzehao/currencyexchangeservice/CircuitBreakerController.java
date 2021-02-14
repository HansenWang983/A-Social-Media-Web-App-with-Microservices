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

    @GetMapping("/sample-api")
    @Retry(name="sample-api", fallbackMethod = "fallbackResponse")
    //@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    //@RateLimiter(name="default")
    public String circuitBreakerApi(){
        logger.info("sample api received");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://127.0.0.1:8000/", String.class);
        return forEntity.getBody();
//        return "sample-api";
    }

    public String fallbackResponse(Exception ex){
        return "fall-back-response";
    }
}
