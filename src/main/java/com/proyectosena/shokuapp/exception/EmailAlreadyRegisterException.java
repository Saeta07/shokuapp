package com.proyectosena.shokuapp.exception;

public class EmailAlreadyRegisterException extends RuntimeException{
    public static final String MESSAGE = "El mail que está intentando registrar ya se encuentra en nuestra base de datos";

    public EmailAlreadyRegisterException() {
    }

    public EmailAlreadyRegisterException(String message) {
        super(message);
    }
}
