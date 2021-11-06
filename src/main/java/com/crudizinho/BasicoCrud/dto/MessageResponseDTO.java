package com.crudizinho.BasicoCrud.dto;

import lombok.Builder;
import lombok.Data;

@Data // Insere todos os Getters e Setters
@Builder // Para Construir objetos
public class MessageResponseDTO {

    private String message;

}
