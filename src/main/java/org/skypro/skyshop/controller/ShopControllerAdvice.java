package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.exceptions.NoSuchProductException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {
    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<String> noSuchProduct(NoSuchProductException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
