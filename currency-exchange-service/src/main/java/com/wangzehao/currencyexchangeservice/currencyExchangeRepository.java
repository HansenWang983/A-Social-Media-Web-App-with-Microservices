package com.wangzehao.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;

@Repository
public interface currencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    public CurrencyExchange findByFromAndTo(String from, String to);
}
