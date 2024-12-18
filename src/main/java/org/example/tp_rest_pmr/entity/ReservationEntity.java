package org.example.tp_rest_pmr.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entité JPA représentant une réservation.
 * Cette classe mappe la table `reservation` dans la base de données.
 */
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "reservation")
public class ReservationEntity {

    /**
     * Clé primaire composite pour la réservation, représentée par un objet {@link EmbeddedIdReservation}.
     * Cette clé est composée de l'identifiant du PMR et de l'identifiant de l'utilisateur.
     */
    @EmbeddedId
    private EmbeddedIdReservation id;

    /**
     * Identifiant ou numéro de la réservation.
     */
    @Column(name = "reservation", nullable = false)
    private Integer reservation;

    /**
     * Relation Many-to-One avec l'entité {@link PmrEntity}, représentant le PMR concerné par la réservation.
     * Utilisation de {@link MapsId} pour lier cette relation à la clé composite.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pmr_id")
    @JoinColumn(name = "pmr_id")
    private PmrEntity pmr;

    /**
     * Relation Many-to-One avec l'entité {@link UtilisateurEntity}, représentant l'utilisateur ayant effectué la réservation.
     * Utilisation de {@link MapsId} pour lier cette relation à la clé composite.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("utilisateur_id")
    @JoinColumn(name = "utilisateur_id")
    private UtilisateurEntity utilisateur;
}
