package com.dailycodechallenge.bankloanenquiries.controller;

import com.dailycodechallenge.bankloanenquiries.entity.LoanEnqury;
import com.dailycodechallenge.bankloanenquiries.proxy.BankLoanProxy;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class LoanEnquiryController {

    BankLoanProxy bankLoanProxy;

    @GetMapping("/bank-loan-enquiries/{type}/{amount}/{year}")
    public LoanEnqury getLoanEnquryDetail(@PathVariable String type,
                                          @PathVariable BigDecimal amount,
                                          @PathVariable Long year)
    {
        LoanEnqury loanEnqury = bankLoanProxy.getLoanEnquiry(type);
        loanEnqury.setLoanAmount(amount);
        loanEnqury.setLoanYears(year);
        loanEnqury.setLoanInterest(getInterestAmt(amount, loanEnqury));
        loanEnqury.setLoanRepayment(amount.add(loanEnqury.getLoanInterest()));
        return loanEnqury;
    }

    private BigDecimal getInterestAmt(@PathVariable BigDecimal amount, LoanEnqury loanEnqury) {
        return amount.multiply(loanEnqury.getLoanRate()).divide(BigDecimal.valueOf(100));
    }
}
