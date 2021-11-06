package com.crudizinho.BasicoCrud.dto.request;


import com.crudizinho.BasicoCrud.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING) // Informa que o tipo de Enum será String
    private PhoneType type;

    @NotEmpty // Informa que o campo é NOT NULL
    @Size(min = 13, max = 14) // Tamanho MAX e MIN para o campo
    private String number;


}
