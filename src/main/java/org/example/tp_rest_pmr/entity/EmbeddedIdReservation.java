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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class EmbeddedIdReservation {

    @Column(name = "pmr_id", nullable = false)
    private Integer pmr;

    @Column(name = "utilisateur_id", nullable = false)
    private Integer utilisateur;
}
