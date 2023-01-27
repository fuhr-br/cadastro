package com.attornatus.cadastro.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public  ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
            List<ApiErroDetalhe> errors = exception.getBindingResult()
                    .getFieldErrors()
                    .stream()
                    .map(p -> new ApiErroDetalhe(p.getField(), p.getDefaultMessage())).toList();

            final String mensagemErroValidacao = "Erro na validação";
            final ApiErro apiErro = new ApiErro(mensagemErroValidacao, errors);
            return ResponseEntity.badRequest().body(apiErro);
        }
    }

