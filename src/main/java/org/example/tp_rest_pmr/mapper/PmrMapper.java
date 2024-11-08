package org.example.tp_rest_pmr.mapper;

import org.example.tp_rest_pmr.dto.PmrDTO;
import org.example.tp_rest_pmr.entity.PmrEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper( uses = ReservationMapper.class )
public interface PmrMapper {
    PmrDTO toDTO(PmrEntity pmr);

    PmrEntity toEntity(PmrDTO pmr);
}
