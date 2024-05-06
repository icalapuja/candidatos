package com.sek.candidatos.app.service;

import com.sek.candidatos.app.exception.ApplicationException;
import com.sek.candidatos.app.service.impl.CandidateServiceImpl;
import com.sek.candidatos.domain.dto.CandidateDTO;
import com.sek.candidatos.domain.mapper.CandidateMapper;
import com.sek.candidatos.domain.model.Candidate;
import com.sek.candidatos.domain.repository.CandidateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CandidateServiceImplTest {
    private CandidateMapper mapper = Mockito.mock(CandidateMapper.class);
    private CandidateRepository repository = Mockito.mock(CandidateRepository.class);

    private CandidateServiceImpl candidateService = new CandidateServiceImpl(mapper, repository);

    List<Candidate> candidates;
    Candidate candidate1 = new Candidate(1L,"Ivan","ivan@gmail.com","M", 100D);
    Candidate candidate2 = new Candidate(1L,"Edson","edson@gmail.com","M", 100D);

    List<CandidateDTO> candidatesDto;
    CandidateDTO candidateDto1 = new CandidateDTO(1L,"Ivan","ivan@gmail.com","M", 100D);
    CandidateDTO candidateDto2 = new CandidateDTO(1L,"Edson","edson@gmail.com","M", 100D);


    @BeforeEach
    void setup(){
        candidates = Arrays.asList(candidate1, candidate2);
        candidatesDto = Arrays.asList(candidateDto1, candidateDto2);


        Mockito.when(mapper.getDTOS(Mockito.anyList())).thenReturn(candidatesDto);
        Mockito.when(mapper.getDTO(Mockito.any(Candidate.class))).thenReturn(candidateDto1);
        Mockito.when(mapper.getEntities(Mockito.anyList())).thenReturn(candidates);
        Mockito.when(mapper.getEntity(Mockito.any(CandidateDTO.class))).thenReturn(candidate1);

        Mockito.when(repository.getAll()).thenReturn(candidates);
        Mockito.when(repository.getById(1L)).thenReturn(candidate1);
        Mockito.when(repository.create(Mockito.any(Candidate.class))).thenReturn(candidate1);
        Mockito.when(repository.update(Mockito.any(Candidate.class))).thenReturn(candidate1);


        // Mockito.when(repository.save(Mockito.any(Candidate.class))).thenReturn(candidate1);
    }

    @Test
    void getAll_should_success() throws ApplicationException {
        List<CandidateDTO> result = candidateService.getAll();
        assertFalse(result.isEmpty());
    }

    @Test
    void getById_should_success() throws ApplicationException{
        CandidateDTO result = candidateService.getById(1L);
        assertNotNull(result);
    }

    @Test
    void create_should_success() throws ApplicationException{
        CandidateDTO result = candidateService.create(candidateDto1);
        assertNotNull(result);
    }

    @Test
    void update_should_success() throws ApplicationException{
        CandidateDTO result = candidateService.update(candidateDto1, 1L);
        assertNotNull(result);
    }
}
