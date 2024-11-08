package org.example.tp_rest_pmr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

import java.io.Serializable;


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
    private Integer pmr_id;

    @Column(name = "utilisateur_id", nullable = false)
    private Integer utilisateur_id;
}
