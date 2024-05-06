package com.sek.candidatos.app.service;

import com.sek.candidatos.app.exception.ApplicationException;
import com.sek.candidatos.domain.dto.CandidateDTO;
import java.util.List;

public interface CandidateService {
    List<CandidateDTO> getAll() throws ApplicationException;
    CandidateDTO getById(Long id) throws ApplicationException;
    CandidateDTO create(CandidateDTO dto) throws ApplicationException;
    CandidateDTO update(CandidateDTO dto, Long id) throws ApplicationException;
}
