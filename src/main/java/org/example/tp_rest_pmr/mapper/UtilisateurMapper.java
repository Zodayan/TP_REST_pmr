package org.example.tp_rest_pmr.mapper;

import org.example.tp_rest_pmr.dto.UtilisateurDTO;
import org.example.tp_rest_pmr.entity.EmbeddedIdReservation;
import org.example.tp_rest_pmr.entity.ReservationEntity;
import org.example.tp_rest_pmr.entity.UtilisateurEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    @Mapping(source = "reservations", target = "reservationsId")
    UtilisateurDTO toDTO(UtilisateurEntity utilisateurEntity);

    @Mapping(source = "reservationsId", target = "reservations")
    UtilisateurEntity toEntity(UtilisateurDTO utilisateurDTO);

    default Set<EmbeddedIdReservation> mapReservations(Set<ReservationEntity> reservations) {
        if (reservations == null) {
            return null;
        }
        return reservations.stream()
                .map(ReservationEntity::getId)
                .collect(Collectors.toSet());
    }

    default Set<ReservationEntity> mapReservationIds(Set<EmbeddedIdReservation> reservationIds) {
        if (reservationIds == null) {
            return null;
        }
        return reservationIds.stream()
                .map(id -> ReservationEntity.builder().id(id).build())
                .collect(Collectors.toSet());
    }
}

