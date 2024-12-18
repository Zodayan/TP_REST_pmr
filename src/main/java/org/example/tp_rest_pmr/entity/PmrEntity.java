package org.example.tp_rest_pmr.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * Entité JPA représentant un PMR (Personne à Mobilité Réduite).
 * Cette classe mappe la table `pmr` dans la base de données.
 */
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "pmr")
public class PmrEntity {

    /**
     * Identifiant unique du PMR.
     * Ce champ est généré automatiquement par la base de données.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * Nom ou désignation du PMR.
     */
    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    /**
     * Quantité disponible associée au PMR.
     */
    @Column(name = "quantite", nullable = false)
    private Integer quantite;

    /**
     * Description détaillée du PMR (facultative).
     */
    @Column(name = "description", length = 100)
    private String description;

    /**
     * Localisation géographique ou point géographique associé au PMR.
     */
    @Column(name = "point_geo", nullable = false, length = 100)
    private String point_geo;

    /**
     * Ensemble des réservations associées à ce PMR.
     * Relation un-à-plusieurs avec l'entité {@link ReservationEntity}.
     */
    @OneToMany(mappedBy = "pmr")
    private Set<ReservationEntity> reservations;

}
