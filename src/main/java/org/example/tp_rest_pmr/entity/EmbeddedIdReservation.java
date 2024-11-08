package org.example.tp_rest_pmr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;


// Permet de définir la clé multiple de la table
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Embeddable
public class EmbeddedIdReservation {

    @ManyToOne
    @JoinColumn(name = "pmr_id")
    private PmrEntity pmr;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private UtilisateurEntity utilisateur;

    /*
    @Column(name = "pmr_id", nullable = false)
    private Integer pmr_id;

    @Column(name = "utilisateur_id", nullable = false)
    private Integer utilisateur_id;

     */
}
