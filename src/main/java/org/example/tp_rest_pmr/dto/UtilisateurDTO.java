package org.example.tp_rest_pmr.dto;

import lombok.*;
import org.example.tp_rest_pmr.entity.EmbeddedIdReservation;

import java.util.Set;

/**
 * Classe de transfert de données (DTO) représentant un utilisateur.
 * Cette classe contient les informations nécessaires pour décrire un utilisateur
 * et ses réservations associées.
 */
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@ToString
public class UtilisateurDTO {

    /**
     * Identifiant unique de l'utilisateur.
     */
    private int id;

    /**
     * Nom de l'utilisateur.
     */
    private String nom;

    /**
     * Prénom de l'utilisateur.
     */
    private String prenom;

    /**
     * Mot de passe de l'utilisateur.
     * Doit être géré avec prudence pour garantir la sécurité (cryptage recommandé).
     */
    private String password;

    /**
     * Adresse e-mail de l'utilisateur.
     */
    private String mail;

    /**
     * Nom d'utilisateur utilisé pour l'authentification ou l'identification.
     */
    private String username;

    /**
     * Ensemble des identifiants de réservations associés à l'utilisateur.
     * Chaque identifiant est représenté par un objet {@link EmbeddedIdReservation}.
     */
    private Set<EmbeddedIdReservation> reservationsId;
}
