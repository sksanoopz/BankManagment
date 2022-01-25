package com.dailycodechallenge.bankloanpalans.controller;

import com.dailycodechallenge.bankloanpalans.entity.LoanType;
import com.dailycodechallenge.bankloanpalans.exception.LoanRequestNotFound;
import com.dailycodechallenge.bankloanpalans.repository.BankLoanRepositroy;
import com.dailycodechallenge.bankloanpalans.service.BankLoanService;
import lombok.AllArgsConstructor;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BankLoanController {

    BankLoanService bankLoanService;
    Environment environment;

    @GetMapping("/bank-loan-plans/{type}")
    public ResponseEntity<?> getLoanPlanDetails(@PathVariable String type)
    {
          LoanType loanType= bankLoanService.retrieveLoanTypeByCode(type);

          if (loanType == null)
              throw  new LoanRequestNotFound();
          loanType.setPort(environment.getProperty("local.server.port"));
          return new ResponseEntity<>(loanType, HttpStatus.OK);

    }

    @PostMapping("/save-details")
     public  ResponseEntity<?> saveBankLoanServices(@RequestBody LoanType loanType)
     {
         LoanType newLoanType = bankLoanService.saveBankLoanService(loanType);
         return new ResponseEntity<>(newLoanType,HttpStatus.CREATED);
     }


}
