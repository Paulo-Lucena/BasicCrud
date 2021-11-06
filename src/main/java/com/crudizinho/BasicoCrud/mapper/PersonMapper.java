package com.crudizinho.BasicoCrud.mapper;


import com.crudizinho.BasicoCrud.dto.request.PersonDTO;
import com.crudizinho.BasicoCrud.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}


// Essa classe serve para converter de Modelo para DTO e vice-versa.