package com.sek.candidatos.app.exception;

import com.sek.candidatos.domain.dto.ResponseErrorDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;

@RestControllerAdvice
public class ResponseExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<?> handlerMethodArgumentValidExceptions(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        ResponseErrorDTO responseErrorDTO = new ResponseErrorDTO(errors);
        return new ResponseEntity<>(responseErrorDTO, HttpStatus.BAD_REQUEST);
    }
}
