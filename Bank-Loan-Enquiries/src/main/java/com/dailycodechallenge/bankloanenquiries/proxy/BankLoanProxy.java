package com.dailycodechallenge.bankloanenquiries.proxy;

import com.dailycodechallenge.bankloanenquiries.entity.LoanEnqury;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bank-loan-plans")
public interface BankLoanProxy {

    @GetMapping("/bank-loan-plans/{type}")
    public LoanEnqury getLoanEnquiry(@PathVariable String type);
}
