package nl.inholland.tentamen.controller;

import nl.inholland.tentamen.model.dto.ExceptionResponseDTO;
import nl.inholland.tentamen.model.exception.ProductNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ProductNotFoundException.class})
    protected ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {
        ExceptionResponseDTO dto = new ExceptionResponseDTO(ex.getMessage());
        return handleExceptionInternal(ex, dto, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException  ex, WebRequest request) {
        List<String> details = ex
                .getConstraintViolations()
                .parallelStream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());

        ExceptionResponseDTO dto = new ExceptionResponseDTO(details.toString());
        return handleExceptionInternal(ex, dto, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponseDTO dto = new ExceptionResponseDTO("Data transfer not succeeded");
        return handleExceptionInternal(ex, dto, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
