package com.crudizinho.BasicoCrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Significa que o controlador será acessado através de uma API REST.
@RequestMapping("/api/v1/people") // Informa o caminho de acesso principal da API.
public class PersonController {

    @GetMapping
    public String getBook(){
        return "SrLucena";
    }
}
