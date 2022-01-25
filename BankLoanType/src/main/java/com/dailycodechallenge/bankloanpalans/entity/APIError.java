package com.dailycodechallenge.bankloanpalans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIError {

    private HttpStatus status;
    private List<String> errors;
    private Date timestamp;
    private String path;
}
