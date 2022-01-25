package com.dailycodechallenge.bankloanpalans.controller;

import com.dailycodechallenge.bankloanpalans.entity.LoanType;
import com.dailycodechallenge.bankloanpalans.service.BankLoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

@WebMvcTest(BankLoanController.class)
class BankLoanControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    BankLoanService bankLoanService;

    LoanType loanType = new LoanType();

    @BeforeEach
    void setUp() {
        loanType = LoanType.builder()
                .loanType_ID(10)
                .loanType("GL")
                .loanRate(BigDecimal.valueOf(20))
                .loanTypeName("Gold Loan")
                .build();
    }

    @Test
    void getLoanPlanDetails() throws Exception {
        Mockito.when(bankLoanService.retrieveLoanTypeByCode("GL"))
                .thenReturn(loanType);
        mockMvc.perform(MockMvcRequestBuilders.get("/bank-loan-plans/GL")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void saveBankLoanServices() throws Exception {
        LoanType loanTypeInput = LoanType.builder()
                .loanType("GL")
                .loanRate(BigDecimal.valueOf(20))
                .loanTypeName("Gold Loan")
                .build();
        Mockito.when(bankLoanService.saveBankLoanService(loanTypeInput))
                .thenReturn(loanType);
        mockMvc.perform(MockMvcRequestBuilders.post("/save-details")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "  \"loanType\": \"CL\",\n" +
                "  \"loanTypeName\": \"Car  Loan\",\n" +
                "  \"loanRate\": 10,\n" +
                "  \"port\": \"8081\"\n" +
                "}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}