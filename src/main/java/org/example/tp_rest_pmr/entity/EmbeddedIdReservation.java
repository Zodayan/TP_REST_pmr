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
    private Integer pmr_id;

    @Column(name = "utilisateur_id", nullable = false)
    private Integer utilisateur_id;

    @Override
    public int hashCode() {
        return pmr_id.hashCode() + utilisateur_id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        EmbeddedIdReservation other = (EmbeddedIdReservation) obj;
        return other.pmr_id.equals(this.pmr_id) && other.utilisateur_id.equals(this.utilisateur_id);
    }
}
