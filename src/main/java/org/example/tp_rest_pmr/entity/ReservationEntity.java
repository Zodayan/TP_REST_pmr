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

    @Column(name = "reservation", nullable = false)
    private int reservation;

    @EmbeddedId
    private EmbeddedIdReservation id;

    @ManyToOne
    @JoinColumn(name = "pmr_id")
    private PmrEntity pmr_id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private UtilisateurEntity utilisateurs;
}
