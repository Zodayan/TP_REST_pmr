package org.example.tp_rest_pmr.dto;

import lombok.*;
import org.example.tp_rest_pmr.entity.EmbeddedIdReservation;
import org.example.tp_rest_pmr.entity.ReservationEntity;

import java.util.Set;

/**
 * Classe de transfert de données (DTO) pour représenter les informations d'un PMR (personne à mobilité réduite).
 * Elle contient les données nécessaires pour manipuler ou transférer ces informations
 * entre différentes couches de l'application.
 */
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@ToString
public class PmrDTO {

    /**
     * Identifiant unique du PMR.
     */
    private int id;

    /**
     * Nom ou désignation du PMR.
     */
    private String nom;

    /**
     * Quantité associée au PMR (par exemple, nombre d'éléments disponibles).
     */
    private int quantite;

    /**
     * Description du PMR, fournissant des détails supplémentaires.
     */
    private String description;

    /**
     * Localisation géographique ou point géographique associé au PMR.
     */
    private String point_geo;

    /**
     * Ensemble des identifiants de réservations associés au PMR.
     * Chaque identifiant est représenté par un objet {@link EmbeddedIdReservation}.
     */
    private Set<EmbeddedIdReservation> reservationsId;
}
