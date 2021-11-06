package com.crudizinho.BasicoCrud.service;

import com.crudizinho.BasicoCrud.dto.MessageResponseDTO;
import com.crudizinho.BasicoCrud.dto.request.PersonDTO;
import com.crudizinho.BasicoCrud.entity.Person;
import com.crudizinho.BasicoCrud.mapper.PersonMapper;
import com.crudizinho.BasicoCrud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service // Vai indicar ao Spring que aqui ficará as regras de negocio da aplicação
public class PersonService {

    private PersonRepository personRepository; // Para injetar a classe PersonRepository

    private final PersonMapper personMapper = PersonMapper.INSTANCE; //  Para injetar a classe PersonMapper que irá converter os DTOs

    @Autowired // Irá dar um Autowired no contrutor da classe e implentará a interfacePersonRepository (Injetar dentro de um construtor facilita para fazer testes unitários)
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO); // Utilizando a convresão do MapStruc

        Person savedPerson = personRepository.save(personToSave); // Para salvar o objeto no DB
        return MessageResponseDTO // com esse retorno, evitamos criar um construtor para a classe MessageResponseDTO
                .builder()
                .message("Pessoa criada com o ID " + savedPerson.getId()) // Mensagem que irá retornar após a criação
                .build();
    }


    public List<PersonDTO> listAll() { //Metodo FindAll
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream() //Api Stram para transformar os dados em coleções
                .map(personMapper::toDTO) // Para cada um dos registros da lista, vai ser chamado o metodo person, e será convertida para DTO
                .collect(Collectors.toList()); //Saída será uma lista
    }
}
