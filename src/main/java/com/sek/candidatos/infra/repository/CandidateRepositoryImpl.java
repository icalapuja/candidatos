package com.sek.candidatos.infra.repository;

import com.sek.candidatos.domain.model.Candidate;
import com.sek.candidatos.domain.repository.CandidateRepository;
import com.sek.candidatos.infra.repository.db.CandidateJpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CandidateRepositoryImpl implements CandidateRepository {
    private final CandidateJpaRepository repository;

    public CandidateRepositoryImpl(CandidateJpaRepository repository){
        this.repository = repository;
    }


    @Override
    public List<Candidate> getAll() {
        return repository.findAll();
    }

    @Override
    public Candidate getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Candidate create(Candidate entity) {
        return repository.save(entity);
    }

    @Override
    public Candidate update(Candidate entity) {
        return repository.save(entity);
    }
}
