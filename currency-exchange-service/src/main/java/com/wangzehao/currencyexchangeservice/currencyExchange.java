package com.wangzehao.currencyexchangeservice;


import java.math.BigDecimal;

public class currencyExchange {
    private Long id;
    private String from;
    private String to;
    private BigDecimal multiple;
    private String environment;

    public currencyExchange(){}

    public currencyExchange(Long id, String from, String to, BigDecimal multiple, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.multiple = multiple;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getMultiple() {
        return multiple;
    }

    public void setMultiple(BigDecimal multiple) {
        this.multiple = multiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
