package com.taxcalculator.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxcalculator.demo.model.Share;

public interface SharesRepository extends JpaRepository<Share, Integer> {

}
