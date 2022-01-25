package com.dailycodechallenge.bankloanpalans.exception;

import com.dailycodechallenge.bankloanpalans.entity.APIError;
import com.sun.corba.se.spi.activation.NoSuchEndPoint;
import org.hibernate.exception.ConstraintViolationException;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.ServletException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

@ControllerAdvice
public class LoanExceptionHandler extends ResponseEntityExceptionHandler {



   /* @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<String> errors = fieldErrors
                .stream()
                .map(err -> err.getField() + ":" + err.getDefaultMessage())
                .collect(Collectors.toList());

        APIError apiError = new APIError();
        apiError.setErrors(errors);
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        apiError.setPath(request.getDescription(false));

        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }*/

    @ExceptionHandler(value=LoanRequestNotFound.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleConstraintViolation(
            LoanRequestNotFound ex, ServletWebRequest request) {

        APIError apiError = new APIError();
        apiError.setErrors(Arrays.asList("Not valid!!"));
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        apiError.setPath(request.getRequest().getRequestURI());
        apiError.setTimestamp(new Date());
        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler(value=Exception.class)
  //  @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleGlobalException
            (Exception ex, ServletWebRequest request)
    {
        APIError apiError = new APIError();
        apiError.setErrors(Arrays.asList("Not Valid URL"));
        apiError.setStatus(HttpStatus.BAD_GATEWAY);
        apiError.setPath("not");
        apiError.setTimestamp(new Date());
        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }
}
