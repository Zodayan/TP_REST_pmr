package org.example.tp_rest_pmr.dto;

import lombok.*;

/**
 * Classe de transfert de données (DTO) représentant une réservation.
 * Cette classe permet de manipuler les données liées à une réservation,
 * y compris les informations de l'utilisateur et du PMR concerné.
 */
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationDTO {

    /**
     * Informations de l'utilisateur ayant effectué la réservation.
     * Représenté par un objet {@link UtilisateurDTO}.
     */
    private UtilisateurDTO utilisateur;

    /**
     * Informations sur le PMR concerné par la réservation.
     * Représenté par un objet {@link PmrDTO}.
     */
    private PmrDTO pmr;

    /**
     * Identifiant ou numéro associé à la réservation.
     */
    private Integer reservation;
}
