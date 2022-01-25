package com.dailycodechallenge.bankloanpalans.service;

import com.dailycodechallenge.bankloanpalans.entity.LoanType;
import com.dailycodechallenge.bankloanpalans.repository.BankLoanRepositroy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BankLoanService {

    BankLoanRepositroy bankLoanRepositroy;

    public LoanType retrieveLoanTypeByCode(String code )
    {
        Optional<LoanType> loanType = bankLoanRepositroy.findByLoanType(code);
        if (loanType.isPresent())
            return loanType.get();
        else
            return new LoanType();
    }

    public LoanType saveBankLoanService(LoanType loanType) {
        return bankLoanRepositroy.save(loanType);
    }
}
