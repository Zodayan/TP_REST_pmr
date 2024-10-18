package org.example.tp_rest_pmr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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

    @Column(name = "pmr_id", nullable = false)
    private int pmr_id;

    @Column(name = "utilisateur_id", nullable = false)
    private int utilisateur_id;
}
