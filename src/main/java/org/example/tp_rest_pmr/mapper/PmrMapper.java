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

/**
 * Interface Mapper pour la conversion entre les entités et les objets DTO pour le PMR.
 * Utilise MapStruct pour générer automatiquement les méthodes de mappage entre les entités {@link PmrEntity} et {@link PmrDTO}.
 */
@Mapper(componentModel = "spring")
public interface PmrMapper {

    /**
     * Convertit une entité {@link PmrEntity} en un objet DTO {@link PmrDTO}.
     * Le mappage entre les réservations de l'entité et les identifiants de réservation du DTO est effectué.
     *
     * @param pmr L'entité {@link PmrEntity} à convertir.
     * @return L'objet DTO {@link PmrDTO} résultant de la conversion.
     */
    @Mapping(source = "reservations", target = "reservationsId")
    PmrDTO toDTO(PmrEntity pmr);

    /**
     * Convertit un objet DTO {@link PmrDTO} en une entité {@link PmrEntity}.
     * Le mappage entre les identifiants de réservation du DTO et les réservations de l'entité est effectué.
     *
     * @param pmr L'objet DTO {@link PmrDTO} à convertir.
     * @return L'entité {@link PmrEntity} résultant de la conversion.
     */
    @Mapping(source = "reservationsId", target = "reservations")
    PmrEntity toEntity(PmrDTO pmr);

    /**
     * Convertit un ensemble de réservations ({@link ReservationEntity}) en un ensemble d'identifiants de réservations ({@link EmbeddedIdReservation}).
     * Cette méthode est utilisée pour mapper les réservations d'une entité {@link PmrEntity} vers un DTO.
     *
     * @param reservations L'ensemble de réservations à convertir.
     * @return Un ensemble d'identifiants de réservations convertis.
     */
    default Set<EmbeddedIdReservation> mapReservations(Set<ReservationEntity> reservations) {
        if (reservations == null) {
            return null;
        }
        return reservations.stream()
                .map(ReservationEntity::getId)
                .collect(Collectors.toSet());
    }

    /**
     * Convertit un ensemble d'identifiants de réservations ({@link EmbeddedIdReservation}) en un ensemble de réservations ({@link ReservationEntity}).
     * Cette méthode est utilisée pour mapper les identifiants de réservations d'un DTO vers une entité {@link PmrEntity}.
     *
     * @param reservationIds L'ensemble d'identifiants de réservations à convertir.
     * @return Un ensemble de réservations convertis.
     */
    default Set<ReservationEntity> mapReservationIds(Set<EmbeddedIdReservation> reservationIds) {
        if (reservationIds == null) {
            return null;
        }
        return reservationIds.stream()
                .map(id -> ReservationEntity.builder().id(id).build())
                .collect(Collectors.toSet());
    }
}
