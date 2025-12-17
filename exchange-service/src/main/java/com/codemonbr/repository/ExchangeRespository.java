package com.codemonbr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codemonbr.model.Exchange;

public interface ExchangeRespository extends JpaRepository<Exchange, Long> {

    Exchange findByFromAndTo(String from, String to);

}
