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
    private currencyExchangeRepository repository;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        CurrencyExchange currencyExchange
                = repository.findByFromAndTo(from, to);

        if(currencyExchange ==null) {
            throw new RuntimeException
                    ("Unable to Find data for " + from + " to " + to);
        }

        String env = environment.getProperty("local.server.port");
        return currencyExchange;
    }
}
