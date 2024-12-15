package org.example.tp_rest_pmr.mapper;

import org.example.tp_rest_pmr.dto.PmrDTO;
import org.example.tp_rest_pmr.dto.UtilisateurDTO;
import org.example.tp_rest_pmr.entity.EmbeddedIdReservation;
import org.example.tp_rest_pmr.entity.PmrEntity;
import org.example.tp_rest_pmr.entity.ReservationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PmrMapper {

    @Mapping(source = "reservations", target = "reservationsId")
    PmrDTO toDTO(PmrEntity pmr);

    @Mapping(source = "reservationsId", target = "reservations")
    PmrEntity toEntity(PmrDTO pmr);

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
