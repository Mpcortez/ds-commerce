package com.mpcortez.dscommerce.controllers.handlers;

import com.mpcortez.dscommerce.dto.error.CustomAdviceError;
import com.mpcortez.dscommerce.services.exception.DatabaseException;
import com.mpcortez.dscommerce.services.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomAdviceError> handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        return responseEntityBuilder(getHttpStatusValue(HttpStatus.NOT_FOUND), e.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomAdviceError> handleDatabaseException(DatabaseException e, HttpServletRequest request) {
        return responseEntityBuilder(getHttpStatusValue(HttpStatus.BAD_REQUEST), e.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomAdviceError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        return responseEntityBuilder(getHttpStatusValue(HttpStatus.UNPROCESSABLE_ENTITY), e.getBindingResult().getFieldErrors(), request.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomAdviceError> handleException(Exception e, HttpServletRequest request) {
        var errMsg = "Ocorreu um erro na ação solicitada! Por favor, contate o administrador.";
        log.error(e.getMessage(), e);
        return responseEntityBuilder(getHttpStatusValue(HttpStatus.BAD_REQUEST), errMsg, request.getRequestURI());
    }

    private Integer getHttpStatusValue(HttpStatus status) {
        return status.value();
    }

    private ResponseEntity<CustomAdviceError> responseEntityBuilder(Integer status, String error, String path) {
        var err = new CustomAdviceError(status, path, error);
        return ResponseEntity.status(status).body(err);
    }

    private ResponseEntity<CustomAdviceError> responseEntityBuilder(Integer status, List<FieldError> fieldErrors, String path) {
        var err = new CustomAdviceError(status, path);
        fieldErrors.forEach(f -> err.addFieldErrors(f.getField(), f.getDefaultMessage()));
        return ResponseEntity.status(status).body(err);
    }
}
