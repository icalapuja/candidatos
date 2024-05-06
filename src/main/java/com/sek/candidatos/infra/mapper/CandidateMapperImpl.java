package com.sek.candidatos.infra.mapper;

import com.sek.candidatos.domain.dto.CandidateDTO;
import com.sek.candidatos.domain.mapper.CandidateMapper;
import com.sek.candidatos.domain.model.Candidate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateMapperImpl implements CandidateMapper {
    private final ModelMapper mapper;

    public CandidateMapperImpl(ModelMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public CandidateDTO getDTO(Candidate entity) {
        return mapper.map(entity, CandidateDTO.class);
    }

    @Override
    public Candidate getEntity(CandidateDTO dto) {
        return mapper.map(dto, Candidate.class);
    }

    @Override
    public List<CandidateDTO> getDTOS(List<Candidate> entities) {
        return entities.stream().map(this::getDTO).collect(Collectors.toList());
    }

    @Override
    public List<Candidate> getEntities(List<CandidateDTO> dtos) {
        return dtos.stream().map(this::getEntity).collect(Collectors.toList());
    }
}
