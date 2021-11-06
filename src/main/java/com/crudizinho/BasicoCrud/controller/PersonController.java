package com.crudizinho.BasicoCrud.controller;

import com.crudizinho.BasicoCrud.dto.MessageResponseDTO;
import com.crudizinho.BasicoCrud.dto.request.PersonDTO;
import com.crudizinho.BasicoCrud.entity.Person;
import com.crudizinho.BasicoCrud.repository.PersonRepository;
import com.crudizinho.BasicoCrud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController // Significa que o controlador será acessado através de uma API REST.
@RequestMapping("/api/v1/people") // Informa o caminho de acesso principal da API.
public class PersonController {

    /*@GetMapping // Primeiro metodo para testar a conexão.
    public String getBook(){
        return "SrLucena";*/

    private PersonService personService; // Para injetar a classe PersonService

    @Autowired // Irá dar um Autowired no construtor da classe e implentará a interfacePersonRepository (Injetar dentro de um construtor facilita para fazer testes unitários)
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping // Anotação Post é para criação
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){ //A anotação informa que será uma requisição a criação // @Valid irá fazer a validação de cada um dos atributos informados em DTO
        return personService.createPerson(personDTO);

    }

}
