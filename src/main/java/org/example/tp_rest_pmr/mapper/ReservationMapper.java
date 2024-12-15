package org.example.tp_rest_pmr.mapper;

import org.example.tp_rest_pmr.dto.ReservationDTO;
import org.example.tp_rest_pmr.dto.UtilisateurDTO;
import org.example.tp_rest_pmr.entity.ReservationEntity;
import org.example.tp_rest_pmr.entity.UtilisateurEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PmrMapper.class, UtilisateurMapper.class})
public interface ReservationMapper {

    ReservationDTO toDTO(ReservationEntity reserv);

    ReservationEntity toEntity(ReservationDTO reserv);
}
