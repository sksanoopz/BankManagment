package com.dailycodechallenge.bankloanpalans.repository;

import com.dailycodechallenge.bankloanpalans.entity.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankLoanRepositroy extends JpaRepository<LoanType,Integer> {
    public Optional<LoanType> findByLoanType(String type);
    public LoanType findByLoanTypeName(String type);
}
