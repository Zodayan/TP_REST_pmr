package org.example.tp_rest_pmr.mapper;

import org.example.tp_rest_pmr.dto.UtilisateurDTO;
import org.example.tp_rest_pmr.entity.UtilisateurEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper( uses = ReservationMapper.class )
public interface UtilisateurMapper {
    UtilisateurDTO toDTO(UtilisateurEntity pmr);

    UtilisateurEntity toEntity(UtilisateurDTO pmr);
}

