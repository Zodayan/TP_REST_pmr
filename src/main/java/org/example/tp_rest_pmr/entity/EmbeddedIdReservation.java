package org.example.tp_rest_pmr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

/**
 * Classe représentant une clé composite pour l'entité de réservation.
 * Cette classe est marquée avec l'annotation {@link Embeddable}, permettant
 * son utilisation comme clé composite dans une entité JPA.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class EmbeddedIdReservation {

    /**
     * Identifiant du PMR associé à la réservation.
     * Correspond à la clé primaire partielle.
     */
    @Column(name = "pmr_id", nullable = false)
    private Integer pmr_id;

    /**
     * Identifiant de l'utilisateur associé à la réservation.
     * Correspond à l'autre partie de la clé primaire.
     */
    @Column(name = "utilisateur_id", nullable = false)
    private Integer utilisateur_id;

    /**
     * Méthode pour générer le code de hachage de l'objet, basée sur les champs `pmr_id` et `utilisateur_id`.
     * @return Code de hachage unique pour l'objet.
     */
    @Override
    public int hashCode() {
        return pmr_id.hashCode() + utilisateur_id.hashCode();
    }

    /**
     * Méthode pour vérifier l'égalité entre deux objets `EmbeddedIdReservation`.
     * Deux objets sont égaux s'ils ont les mêmes valeurs pour `pmr_id` et `utilisateur_id`.
     *
     * @param obj L'objet à comparer avec l'instance actuelle.
     * @return `true` si les objets sont égaux, sinon `false`.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        EmbeddedIdReservation other = (EmbeddedIdReservation) obj;
        return other.pmr_id.equals(this.pmr_id) && other.utilisateur_id.equals(this.utilisateur_id);
    }
}
