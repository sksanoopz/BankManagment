package com.dailycodechallenge.bankloanpalans.repository;

import com.dailycodechallenge.bankloanpalans.entity.LoanType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class BankLoanRepositroyTest {

    @Autowired
    BankLoanRepositroy bankLoanRepositroy;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        LoanType loanType = LoanType.builder( )
                .loanTypeName("Gold Loan")
                .loanType("GL")
                .loanRate(BigDecimal.valueOf(9))
                .port("8083")
                .build( );
        entityManager.persist(loanType);
    }

    @Test
    @DisplayName("Test Repository Layer")
    public void findByLoanType() {
        for (int i=0;i<1000;i++)
        {
            int j= i+1;
            j++;
        }

       LoanType loanType = bankLoanRepositroy.findByLoanType("GL").get();
       assertEquals("GL",loanType.getLoanType());
    }
}