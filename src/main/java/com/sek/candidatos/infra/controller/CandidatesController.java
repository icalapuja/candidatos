package com.sek.candidatos.infra.controller;

import com.sek.candidatos.app.exception.ApplicationException;
import com.sek.candidatos.app.service.CandidateService;
import com.sek.candidatos.domain.dto.CandidateDTO;
import com.sek.candidatos.domain.dto.ResponseErrorDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("api/candidates")
public class CandidatesController {
    private final CandidateService candidateService;

    public CandidatesController(CandidateService candidateService){
        this.candidateService = candidateService;
    }


    @GetMapping
    public ResponseEntity<?> getAll(){
        try{
            return new ResponseEntity<>(this.candidateService.getAll(), HttpStatus.OK);
        }catch (ApplicationException ex){
            return new ResponseEntity<>(new ResponseErrorDTO(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try{
            return Optional.ofNullable(this.candidateService.getById(id))
                    .map(item->new ResponseEntity<>(item, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        }catch (ApplicationException ex){
            return new ResponseEntity<>(new ResponseErrorDTO(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestBody CandidateDTO request){
        try{
            return Optional.ofNullable(this.candidateService.create(request))
                    .map(item->new ResponseEntity<>(item, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }catch (ApplicationException ex){
            return new ResponseEntity<>(new ResponseErrorDTO(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@Valid @RequestBody CandidateDTO request, @PathVariable Long id){
        try{
            return Optional.ofNullable(this.candidateService.update(request, id))
                    .map(item->new ResponseEntity<>(item, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }catch (ApplicationException ex){
            return new ResponseEntity<>(new ResponseErrorDTO(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
