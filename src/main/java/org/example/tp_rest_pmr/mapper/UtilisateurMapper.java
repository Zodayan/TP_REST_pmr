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

/**
 * Interface Mapper pour la conversion entre les entités et les objets DTO pour les utilisateurs.
 * Utilise MapStruct pour générer automatiquement les méthodes de mappage entre les entités {@link UtilisateurEntity} et {@link UtilisateurDTO}.
 */
@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    /**
     * Convertit une entité {@link UtilisateurEntity} en un objet DTO {@link UtilisateurDTO}.
     * Le mappage entre les réservations de l'entité et les identifiants de réservation du DTO est effectué.
     *
     * @param utilisateurEntity L'entité {@link UtilisateurEntity} à convertir.
     * @return L'objet DTO {@link UtilisateurDTO} résultant de la conversion.
     */
    @Mapping(source = "reservations", target = "reservationsId")
    UtilisateurDTO toDTO(UtilisateurEntity utilisateurEntity);

    /**
     * Convertit un objet DTO {@link UtilisateurDTO} en une entité {@link UtilisateurEntity}.
     * Le mappage inverse entre les identifiants de réservation du DTO et les réservations de l'entité est effectué.
     *
     * @param utilisateurDTO L'objet DTO {@link UtilisateurDTO} à convertir.
     * @return L'entité {@link UtilisateurEntity} résultant de la conversion.
     */
    @Mapping(source = "reservationsId", target = "reservations")
    UtilisateurEntity toEntity(UtilisateurDTO utilisateurDTO);

    /**
     * Convertit un ensemble de réservations ({@link ReservationEntity}) en un ensemble d'identifiants de réservations ({@link EmbeddedIdReservation}).
     * Cette méthode est utilisée pour mapper les réservations d'une entité {@link UtilisateurEntity} vers un DTO.
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
     * Cette méthode est utilisée pour mapper les identifiants de réservations d'un DTO vers une entité {@link UtilisateurEntity}.
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
