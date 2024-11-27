package org.example.tp_rest_pmr.mapper;

import org.example.tp_rest_pmr.dto.PmrDTO;
import org.example.tp_rest_pmr.entity.PmrEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.annotation.ManagedAttribute;


@Mapper( uses = ReservationMapper.class )
public interface PmrMapper {
    PmrDTO toDTO(PmrEntity pmr);

    PmrEntity toEntity(PmrDTO pmr);
}
