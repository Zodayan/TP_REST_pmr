package org.example.tp_rest_pmr.mapper;

import org.example.tp_rest_pmr.dto.ReservationDTO;
import org.example.tp_rest_pmr.dto.UtilisateurDTO;
import org.example.tp_rest_pmr.entity.ReservationEntity;
import org.example.tp_rest_pmr.entity.UtilisateurEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ReservationMapper {
    @Mapping(source = "id.pmr", target = "pmr")
    @Mapping(source = "id.utilisateur", target = "utilisateur")
    ReservationDTO toDTO(ReservationEntity reserv);

    @Mapping(target = "id.pmr", source = "pmr")
    @Mapping(target = "id.utilisateur", source = "utilisateur")
    ReservationEntity toEntity(ReservationDTO reserv);
}
