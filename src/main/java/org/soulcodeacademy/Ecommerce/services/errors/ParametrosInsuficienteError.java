package org.soulcodeacademy.Ecommerce.services.errors;

public class ParametrosInsuficienteError extends RuntimeException {

    public ParametrosInsuficienteError(String message){
        super(message);
    }
}
