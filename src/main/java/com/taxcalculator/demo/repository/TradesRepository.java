package com.taxcalculator.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxcalculator.demo.model.Trade;

public interface TradesRepository extends JpaRepository<Trade, Integer> {

}
