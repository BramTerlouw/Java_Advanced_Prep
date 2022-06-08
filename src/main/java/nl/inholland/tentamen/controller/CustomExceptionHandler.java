package nl.inholland.tentamen.controller;

import nl.inholland.tentamen.model.dto.ExceptionResponseDTO;
import nl.inholland.tentamen.model.exception.ProductNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ProductNotFoundException.class})
    protected ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {
        ExceptionResponseDTO dto = new ExceptionResponseDTO("Product could not be found!.");
        return handleExceptionInternal(ex, dto, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
    }
}
