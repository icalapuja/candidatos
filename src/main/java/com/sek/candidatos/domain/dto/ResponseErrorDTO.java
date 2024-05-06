package com.sek.candidatos.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseErrorDTO {
    public ResponseErrorDTO(String error){
        this.errors = Arrays.asList(error);
    }

    List<String> errors;
}
