package org.example.tp_rest_pmr.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "reservation")
public class ReservationEntity {
    @EmbeddedId
    private EmbeddedIdReservation id;

    @Column(name = "reservation", nullable = false)
    private Integer reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pmr_id")
    @JoinColumn(name = "pmr_id")
    private PmrEntity pmr;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("utilisateur_id")
    @JoinColumn(name = "utilisateur_id")
    private UtilisateurEntity utilisateur;
}
