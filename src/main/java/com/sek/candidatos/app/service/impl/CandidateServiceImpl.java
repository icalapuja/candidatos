package com.sek.candidatos.app.service.impl;

import com.sek.candidatos.app.exception.ApplicationException;
import com.sek.candidatos.app.service.CandidateService;
import com.sek.candidatos.domain.dto.CandidateDTO;
import com.sek.candidatos.domain.mapper.CandidateMapper;
import com.sek.candidatos.domain.model.Candidate;
import com.sek.candidatos.domain.repository.CandidateRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {
    private final CandidateMapper candidateMapper;
    private final CandidateRepository candidateRepository;

    public CandidateServiceImpl(CandidateMapper candidateMapper, CandidateRepository candidateRepository){
        this.candidateMapper = candidateMapper;
        this.candidateRepository = candidateRepository;
    }


    @Override
    public List<CandidateDTO> getAll() throws ApplicationException {
        try{
            return this.candidateMapper.getDTOS(this.candidateRepository.getAll());
        }catch (Exception ex){
            throw new ApplicationException(ex.getMessage());
        }
    }

    @Override
    public CandidateDTO getById(Long id) throws ApplicationException{
        try{
            return Optional.ofNullable(this.candidateRepository.getById(id))
                    .map(this.candidateMapper::getDTO)
                    .orElse(null);
        }catch (Exception ex){
            throw new ApplicationException(ex.getMessage());
        }
    }

    @Override
    public CandidateDTO create(CandidateDTO dto) throws ApplicationException{
        try{
            return Optional.ofNullable(this.candidateRepository.create(this.candidateMapper.getEntity(dto)))
                    .map(this.candidateMapper::getDTO)
                    .orElse(null);
        }catch (Exception ex){
            throw new ApplicationException(ex.getMessage());
        }
    }

    @Override
    public CandidateDTO update(CandidateDTO dto, Long id) throws ApplicationException{
        try{
            Candidate candidate = this.candidateRepository.getById(id);

            if(Objects.isNull(candidate)){
                throw new ApplicationException("Candidate not found");
            }

            dto.setId(id);

            return Optional.ofNullable(this.candidateRepository.update(this.candidateMapper.getEntity(dto)))
                    .map(this.candidateMapper::getDTO)
                    .orElse(null);
        }catch (Exception ex){
            throw new ApplicationException(ex.getMessage());
        }
    }
}
