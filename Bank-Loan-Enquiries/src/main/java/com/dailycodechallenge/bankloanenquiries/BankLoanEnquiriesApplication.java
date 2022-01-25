package com.dailycodechallenge.bankloanenquiries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BankLoanEnquiriesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankLoanEnquiriesApplication.class, args);
    }

}
