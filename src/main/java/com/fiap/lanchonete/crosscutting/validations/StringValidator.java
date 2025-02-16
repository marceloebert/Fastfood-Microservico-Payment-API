package com.fiap.lanchonete.crosscutting.validations;

public class StringValidator {

    public static boolean isNullOrEmpty(String value){
        return value == null || value.isBlank();
    }

}
