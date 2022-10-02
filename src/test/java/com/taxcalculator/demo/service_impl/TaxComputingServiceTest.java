package com.taxcalculator.demo.service_impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.taxcalculator.demo.repository.SharesRepository;
import com.taxcalculator.demo.repository.TradesRepository;
import com.taxcalculator.demo.utils.TestUtils;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TaxComputingServiceTest {

	@InjectMocks
	TaxComputingServiceImpl taxComputingServiceImpl;

	@Mock
	SharesRepository sharesRepository;

	@Mock
	TradesRepository tradesRepository;

	@Test
	void test_computeTax() {
		assertEquals(60.0, taxComputingServiceImpl.computeTax(3, 1000, 2));
	}

	@Test
	void test_computePrice(){
		assertEquals(550.0, taxComputingServiceImpl.computePrice(5, 100, 50));
	}
	
	@Test
	void test_getShareDetails() {
		Mockito.when(sharesRepository.findAll()).thenReturn(TestUtils.getShareList());
		assertEquals(1, taxComputingServiceImpl.getShareDetails().size());
	}

	@Test
	void test_addShare() {
		Mockito.when(sharesRepository.save(Mockito.any())).thenReturn(TestUtils.getShare());
		assertEquals(1, taxComputingServiceImpl.addShare(TestUtils.getShare()));
	}

	@Test
	void test_getTradeDetails() {
		Mockito.when(tradesRepository.findAll()).thenReturn(TestUtils.getTradeList());
		assertEquals(1, taxComputingServiceImpl.getTradeDetails().size());
	}

	@Test
	void test_getTradebyId() {
		Mockito.when(tradesRepository.findById(1)).thenReturn(TestUtils.getTradeOptional());
		assertEquals("MS", tradesRepository.findById(1).get().getShareName());
	}

	
}
