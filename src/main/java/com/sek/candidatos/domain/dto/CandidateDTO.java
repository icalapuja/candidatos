package com.sek.candidatos.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateDTO {
    private Long id;

    @NotEmpty(message = "name debe contener un valor")
    @NotNull(message = "name es un campo obligatorio")
    private String name;

    @NotEmpty(message = "email debe contener un valor")
    @NotNull(message = "email es un campo obligatorio")
    private String email;

    @Size(min = 1, max = 1)
    private String gender;

    private Double salaryExpected;
}
