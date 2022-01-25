package com.dailycodechallenge.bankloanenquiries.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanEnqury {

    private  int loanType_ID;
    private String loanType;
    private String loanTypeName;
    private BigDecimal loanAmount;
    private BigDecimal loanRate;
    private Long loanYears;
    private BigDecimal loanInterest;
    private BigDecimal loanRepayment;
    private String port;
}
