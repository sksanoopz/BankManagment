package com.dailycodechallenge.bankloanpalans.service;

import com.dailycodechallenge.bankloanpalans.entity.LoanType;
import com.dailycodechallenge.bankloanpalans.repository.BankLoanRepositroy;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BankLoanServiceTest {

    @Autowired
    BankLoanService bankLoanService;

    @MockBean
    BankLoanRepositroy bankLoanRepositroy;

    @BeforeEach
    void setUp() {
        Optional<LoanType> loanType =Optional.ofNullable(LoanType.builder( )
                .loanType_ID(10)
                .loanTypeName("Gold Loan")
                .loanType("GL")
                .loanRate(BigDecimal.valueOf(9))
                .port("8083")
                .build( ));
        Mockito.when(bankLoanRepositroy.findByLoanType("GL"))
                .thenReturn( loanType);
    }

    @Test
    public void retrieveLoanTypeByCode() {
       LoanType loanType = bankLoanService.retrieveLoanTypeByCode("GL");
       assertEquals(loanType.getLoanType(),"GL");
       assertEquals(1,1);
    }
}