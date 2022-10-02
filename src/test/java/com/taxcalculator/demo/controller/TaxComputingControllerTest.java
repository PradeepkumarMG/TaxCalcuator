package com.taxcalculator.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.taxcalculator.demo.service.TaxComputingService;
import com.taxcalculator.demo.utils.TestUtils;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TaxComputingController.class)
public class TaxComputingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TaxComputingService taxComputingService;

	@Test
	void getShareDetails() throws Exception {

		when(taxComputingService.getShareDetails()).thenReturn(TestUtils.getShareList());

		mockMvc.perform(get("/shareslist").contentType(MediaType.APPLICATION_JSON)
				.content("{\"shareId\":1,\"shareName\":\"MS\",\"sharePrice\":80.0,\"taxRate\":3}"))
				.andExpect(status().isOk());
	}

	@Test
	void getTradeDetails() throws Exception {

		when(taxComputingService.getTradeDetails()).thenReturn(TestUtils.getTradeList());

		mockMvc.perform(get("/tradeslist").contentType(MediaType.APPLICATION_JSON)
				.content("{\"tradeId\":1,\"shareName\":\"MS\",\"quantity\":10,\"computedTax\":50,\"totalPrice\":550}"))
				.andExpect(status().isOk());
	}

	@Test
	void getTradebyId() throws Exception {

		when(taxComputingService.getTradebyId(1)).thenReturn(TestUtils.getTrade());

		mockMvc.perform(get("/trade/1").contentType(MediaType.APPLICATION_JSON)
				.content("{\"tradeId\":1,\"shareName\":\"MS\",\"quantity\":10,\"computedTax\":50,\"totalPrice\":550}"))
				.andExpect(status().isOk());
	}

	@Test
	void addShare() throws Exception {

		when(taxComputingService.addShare(Mockito.any())).thenReturn(TestUtils.getShare().getShareId());

		mockMvc.perform(post("/addshare").contentType(MediaType.APPLICATION_JSON)
				.content("{\"shareId\":1,\"shareName\":\"MS\",\"sharePrice\":80.0,\"taxRate\":3}"))
				.andExpect(status().isCreated());
	}

	@Test
	void addTrade() throws Exception {

		when(taxComputingService.addTrade(1, 10)).thenReturn(TestUtils.getTrade());

		mockMvc.perform(post("/addtrade/{shareId}/{quantity}", 1, 10).contentType(MediaType.APPLICATION_JSON)
				.content("{\"shareId\":1,\"quantity\":10}")).andExpect(status().isCreated());
	}
}