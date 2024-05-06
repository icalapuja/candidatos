package com.sek.candidatos.domain.repository;

import com.sek.candidatos.domain.model.Candidate;

import java.util.List;

public interface CandidateRepository {
    List<Candidate> getAll();
    Candidate getById(Long id);
    Candidate create(Candidate entity);
    Candidate update(Candidate entity);
}
