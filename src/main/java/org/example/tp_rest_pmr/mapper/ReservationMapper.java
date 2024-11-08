package org.example.tp_rest_pmr.mapper;

import org.example.tp_rest_pmr.dto.ReservationDTO;
import org.example.tp_rest_pmr.dto.UtilisateurDTO;
import org.example.tp_rest_pmr.entity.ReservationEntity;
import org.example.tp_rest_pmr.entity.UtilisateurEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ReservationMapper {
    @Mapping(source = "reservation.reservation_id.pmr_id", target = "pmrId")
    @Mapping(source = "reservation.reservation_id.utilisateur_id", target = "utilisateurId")
    ReservationDTO toDTO(ReservationEntity reserv);

    @Mapping(target = "reservation.reservation_id.pmr_id", source = "pmrId")
    @Mapping(target = "reservation.reservation_id.utilisateur_id", source = "utilisateurId")
    ReservationEntity toEntity(ReservationDTO reserv);
}
