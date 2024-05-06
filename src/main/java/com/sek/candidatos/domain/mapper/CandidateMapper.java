package com.sek.candidatos.domain.mapper;

import com.sek.candidatos.domain.dto.CandidateDTO;
import com.sek.candidatos.domain.model.Candidate;
import java.util.List;

public interface CandidateMapper {
    CandidateDTO getDTO(Candidate entity);
    Candidate getEntity(CandidateDTO dto);
    List<CandidateDTO> getDTOS(List<Candidate> entities);
    List<Candidate> getEntities(List<CandidateDTO> dtos);
}
