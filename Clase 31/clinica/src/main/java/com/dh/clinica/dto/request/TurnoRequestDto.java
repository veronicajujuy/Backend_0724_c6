package com.dh.clinica.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurnoRequestDto {
    @NotNull
    private Integer paciente_id;
    @NotNull
    private Integer odontologo_id;
    @NotNull
    private String fecha;
}
