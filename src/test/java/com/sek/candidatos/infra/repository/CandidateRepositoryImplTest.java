package com.sek.candidatos.infra.repository;

import com.sek.candidatos.domain.model.Candidate;
import com.sek.candidatos.infra.repository.db.CandidateJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class CandidateRepositoryImplTest {
    CandidateJpaRepository jpaRepository = Mockito.mock(CandidateJpaRepository.class);
    CandidateRepositoryImpl candidateRepository = new CandidateRepositoryImpl(jpaRepository);

    List<Candidate> candidates;
    Candidate candidate1 = new Candidate(1L,"Ivan","ivan@gmail.com","M", 100D);
    Candidate candidate2 = new Candidate(1L,"Edson","edson@gmail.com","M", 100D);

    @BeforeEach
    void setup(){
        candidates = Arrays.asList(candidate1, candidate2);
        Mockito.when(jpaRepository.findAll()).thenReturn(candidates);
        Mockito.when(jpaRepository.findById(1L)).thenReturn(Optional.of(candidate1));
        Mockito.when(jpaRepository.save(Mockito.any(Candidate.class))).thenReturn(candidate1);
    }

    @Test
    void getAll_should_success(){
        List<Candidate> result = candidateRepository.getAll();
        assertFalse(result.isEmpty());
    }

    @Test
    void getById_should_success(){
        Candidate result = candidateRepository.getById(1L);
        assertNotNull(result);
    }

    @Test
    void create_should_success(){
        Candidate result = candidateRepository.create(candidate1);
        assertNotNull(result);
    }

    @Test
    void update_should_success(){
        Candidate result = candidateRepository.update(candidate1);
        assertNotNull(result);
    }


}
