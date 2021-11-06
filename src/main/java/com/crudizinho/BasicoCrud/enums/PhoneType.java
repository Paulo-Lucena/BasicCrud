package com.crudizinho.BasicoCrud.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter // Metodo Getter
@AllArgsConstructor // Construir com todo os argumentos
public enum PhoneType {

    HOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");

    private final String description;

}
