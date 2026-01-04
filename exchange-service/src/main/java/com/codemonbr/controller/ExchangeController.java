package com.codemonbr.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemonbr.environment.InstanceInformationService;
import com.codemonbr.model.Exchange;
import com.codemonbr.repository.ExchangeRespository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Exchange Endpoint")
@RestController
@RequestMapping("exchange-service")
public class ExchangeController {

    private Logger logger = LoggerFactory.getLogger(ExchangeController.class);

    @Autowired
    InstanceInformationService informationService;

    @Autowired
    ExchangeRespository repository;

    @Operation(summary = "Get an exchange from amount of currency")
    @GetMapping(value = "/{amount}/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Exchange getExchange(
            @PathVariable("amount") BigDecimal amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to) {

        logger.info("getExchange is called with -> {}, {} and {}", amount, from, to);

        Exchange exchange = repository.findByFromAndTo(from, to);

        if (exchange == null)
            throw new RuntimeException("Currency Unsupported!");

        String port = informationService.retrieveServerPort();
        String host = informationService.retriveInstanceInfo();

        BigDecimal conversionFactor = exchange.getConvertionFactor();
        BigDecimal convertedValue = conversionFactor.multiply(amount);

        exchange.setConvertedValue(convertedValue);
        exchange.setEnvironment(host + " VERSION: kube-v2 PORT " + port);

        return exchange;
    }

    // @GetMapping(value="/{amount}/{from}/{to}", produces =
    // MediaType.APPLICATION_JSON_VALUE)
    // public Exchange getExchange(
    // @PathVariable("amount") BigDecimal amount,
    // @PathVariable("from") String from,
    // @PathVariable("to") String to){
    // return new Exchange(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, "PORT " +
    // informationService.retrieveServerPort());
    // }
}
