package com.crudizinho.BasicoCrud.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;


    @NotEmpty // NOT NULL
    @Size(min = 2, max = 100)
    private String fistName;

    @NotEmpty // NOT NULL
    @Size(min = 2, max = 100)
    private String lastName;

    @NotEmpty // NOT NULL
    @CPF // formato será 000.000.000-00
    private String cpf;


    private String birthDate;

    @NotEmpty // NOT NULL
    @Valid // Informa que irá fazer a validação a partir dos atributos
    private List<PhoneDTO> phones;
}
