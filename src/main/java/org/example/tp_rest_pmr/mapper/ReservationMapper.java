package org.example.tp_rest_pmr.mapper;

import org.example.tp_rest_pmr.dto.ReservationDTO;
import org.example.tp_rest_pmr.dto.UtilisateurDTO;
import org.example.tp_rest_pmr.entity.ReservationEntity;
import org.example.tp_rest_pmr.entity.UtilisateurEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Interface Mapper pour la conversion entre les entités et les objets DTO pour les réservations.
 * Utilise MapStruct pour générer automatiquement les méthodes de mappage entre les entités {@link ReservationEntity} et {@link ReservationDTO}.
 */
@Mapper(uses = {PmrMapper.class, UtilisateurMapper.class})
public interface ReservationMapper {

    /**
     * Convertit une entité {@link ReservationEntity} en un objet DTO {@link ReservationDTO}.
     * Le mappage entre les entités {@link PmrEntity} et {@link UtilisateurEntity} est délégué aux autres Mappers utilisés par cette interface.
     *
     * @param reserv L'entité {@link ReservationEntity} à convertir.
     * @return L'objet DTO {@link ReservationDTO} résultant de la conversion.
     */
    ReservationDTO toDTO(ReservationEntity reserv);

    /**
     * Convertit un objet DTO {@link ReservationDTO} en une entité {@link ReservationEntity}.
     * Le mappage inverse entre les entités {@link PmrEntity} et {@link UtilisateurEntity} est délégué aux autres Mappers utilisés par cette interface.
     *
     * @param reserv L'objet DTO {@link ReservationDTO} à convertir.
     * @return L'entité {@link ReservationEntity} résultant de la conversion.
     */
    ReservationEntity toEntity(ReservationDTO reserv);
}
