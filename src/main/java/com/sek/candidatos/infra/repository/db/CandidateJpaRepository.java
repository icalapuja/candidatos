package com.sek.candidatos.infra.repository.db;

import com.sek.candidatos.domain.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateJpaRepository extends JpaRepository<Candidate, Long> {
}
