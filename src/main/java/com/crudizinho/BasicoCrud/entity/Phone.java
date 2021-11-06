package com.crudizinho.BasicoCrud.entity;


import com.crudizinho.BasicoCrud.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity // Informa que a classe é uma tabela de um DB
@Data // Insere todos os Getters e Setters
@Builder // Para Construir objetos
@AllArgsConstructor // Construir com todo os argumentos
@NoArgsConstructor // Construir sem argumentos
public class Phone {

    @Id //Informa que esse elemento será o ID da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Toda vez que um ID for inserido, ele será incrementado em +1
    private Long id;

    @Enumerated(EnumType.STRING) //Indica que esse elemento receberá enums, no caso, do tipo String
    @Column(nullable = false) // Indica que esse campo é NOT NULL
    private PhoneType type;

    @Column(nullable = false) // Indica que esse campo é NOT NULL
    private String number;
}
