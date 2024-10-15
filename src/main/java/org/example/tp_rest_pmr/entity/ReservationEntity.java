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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation", nullable = false)
    private int reservationId;

    @Id
    @Column(name = "pmr_id", nullable = false)
    private int pmr_id;

    @Id
    @Column(name = "utilisateur_id", nullable = false)
    private int utilisateur_id;

    @MapsId(value = "pmr_id")
    @OneToOne
    @JoinColumn(name = "pmr_id")
    private PmrEntity pmr;

    @MapsId(value = "utilisateur_id")
    @OneToOne
    @JoinColumn(name = "utilisateur_id")
    private UtilisateurEntity utilisateur;
}
