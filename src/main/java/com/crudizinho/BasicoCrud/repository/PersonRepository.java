package com.crudizinho.BasicoCrud.repository;

import com.crudizinho.BasicoCrud.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}


//Essa interface irá estender os metodos de adicionar, deletar e etc sem precisar cria-los manualmente
