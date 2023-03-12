package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.controllers;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.exception.EntityNoEncontradaException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EntityNoEncontradaException.class)
    public String handleEntityNotFoundException(EntityNoEncontradaException ex) {
        return "redirect:/buscar?error=" + ex.getMessage();
    }
}