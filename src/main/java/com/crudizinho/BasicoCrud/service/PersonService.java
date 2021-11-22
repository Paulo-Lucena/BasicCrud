package com.crudizinho.BasicoCrud.service;

import com.crudizinho.BasicoCrud.dto.MessageResponseDTO;
import com.crudizinho.BasicoCrud.dto.request.PersonDTO;
import com.crudizinho.BasicoCrud.entity.Person;
import com.crudizinho.BasicoCrud.exception.PersonNotFoundException;
import com.crudizinho.BasicoCrud.mapper.PersonMapper;
import com.crudizinho.BasicoCrud.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // Vai indicar ao Spring que aqui ficará as regras de negocio da aplicação
@AllArgsConstructor(onConstructor =  @__(@Autowired)) //Substitui o construtor
public class PersonService {

    private PersonRepository personRepository; // Para injetar a classe PersonRepository

    private final PersonMapper personMapper = PersonMapper.INSTANCE; //  Para injetar a classe PersonMapper que irá converter os DTOs

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO); // Utilizando a convresão do MapStruc

        Person savedPerson = personRepository.save(personToSave); // Para salvar o objeto no DB
        return CreateMessageResponse(savedPerson.getId(), "Pessoa criada com o ID ");
    }


    public List<PersonDTO> listAll() { //Metodo FindAll
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream() //Api Stram para transformar os dados em coleções
                .map(personMapper::toDTO) // Para cada um dos registros da lista, vai ser chamado o metodo person, e será convertida para DTO
                .collect(Collectors.toList()); //Saída será uma lista
    }


    public PersonDTO findById(Long id) throws PersonNotFoundException { //throws será a mensagem de exception
        Person person = verifyIfExists(id);

        return  personMapper.toDTO(person);
    }


    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);

    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO); // Utilizando a convresão do MapStruc

        Person updatePerson = personRepository.save(personToUpdate); // Para salvar o objeto no DB
        return CreateMessageResponse(updatePerson.getId(), "Pessoa atualizada com o ID ");
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id)); //Esse metodo evita que o codigo findbyid seja escrito varias vezes, assim fazemos um metodo para codigos repetidos
    }

    private MessageResponseDTO CreateMessageResponse(Long id, String messege) {
        return MessageResponseDTO // com esse retorno, evitamos criar um construtor para a classe MessageResponseDTO
                .builder()
                .message(messege + id) // Mensagem que irá retornar após a criação
                .build();
    }
}
