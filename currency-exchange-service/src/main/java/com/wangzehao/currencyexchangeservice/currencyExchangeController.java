package com.wangzehao.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class currencyExchangeController {

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public currencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        String env = environment.getProperty("local.server.port");
        return new currencyExchange(1000L, from, to, BigDecimal.valueOf(50), env);
    }
}
