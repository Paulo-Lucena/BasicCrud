package com.crudizinho.BasicoCrud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity // Informa que a classe é uma tabela de um DB
@Data // Insere todos os Getters e Setters
@Builder // Para Construir objetos
@AllArgsConstructor // Construir com todo os argumentos
@NoArgsConstructor // Construir sem argumentos
public class Person {

    @Id //Informa que esse elemento será o ID da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Toda vez que um ID for inserido, ele será incrementado em +1
    private Long id;

    @Column(nullable = false) // Indica que esse campo é NOT NULL
    private String fistName;

    @Column(nullable = false) // Indica que esse campo é NOT NULL
    private String lastName;

    @Column(nullable = false, unique = true) // Indica que esse campo é NOT NULL // Unique indica que esse valor será unico no DB
    private String cpf;


    private LocalDate birthDate;

    @Column(nullable = false) // Indica que esse campo é NOT NULL
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}) // Relacionamento = Um para Muitos // fetch = É para performance // Cascade = Ao invés de remover ou adicionar o numero em uma operação separada, essa será realizada como difinido no Cascade
    private List<Phone> phones;

}
