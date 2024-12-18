package org.example.tp_rest_pmr.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * Entité JPA représentant un utilisateur.
 * Cette classe mappe la table `utilisateur` dans la base de données.
 */
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "utilisateur")
public class UtilisateurEntity {

    /**
     * Identifiant unique de l'utilisateur.
     * Ce champ est généré automatiquement par la base de données.
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nom de l'utilisateur.
     */
    @Column(name = "nom", nullable = false)
    private String nom;

    /**
     * Prénom de l'utilisateur.
     */
    @Column(name = "prenom", nullable = false)
    private String prenom;

    /**
     * Adresse e-mail de l'utilisateur.
     */
    @Column(name = "mail", nullable = false)
    private String mail;

    /**
     * Mot de passe de l'utilisateur.
     * Il est recommandé de gérer ce champ avec des mécanismes de sécurité (cryptage).
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * Nom d'utilisateur unique utilisé pour l'authentification ou l'identification.
     */
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    /**
     * Ensemble des réservations associées à cet utilisateur.
     * Relation un-à-plusieurs avec l'entité {@link ReservationEntity}.
     */
    @OneToMany(mappedBy = "utilisateur")
    private Set<ReservationEntity> reservations;
}
