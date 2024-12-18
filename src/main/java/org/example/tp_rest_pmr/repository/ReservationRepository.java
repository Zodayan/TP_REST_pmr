package org.example.tp_rest_pmr.repository;

import org.example.tp_rest_pmr.entity.EmbeddedIdReservation;
import org.example.tp_rest_pmr.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface Repository pour l'entité {@link ReservationEntity}.
 * Cette interface étend {@link JpaRepository} et permet de gérer les opérations de persistance pour les entités {@link ReservationEntity}.
 * Elle fournit des méthodes pour accéder aux données des réservations dans la base de données.
 */
@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, EmbeddedIdReservation> {

    /**
     * Recherche une réservation par son identifiant composite.
     *
     * @param embeddedIdReservation L'identifiant composite de la réservation à rechercher.
     * @return L'entité {@link ReservationEntity} correspondant à l'identifiant donné.
     */
    ReservationEntity findReservationById(EmbeddedIdReservation embeddedIdReservation);

    /**
     * Recherche les réservations associées à un utilisateur par son nom d'utilisateur.
     * Utilise une requête personnalisée avec JPQL pour effectuer la recherche.
     *
     * @param username Le nom d'utilisateur de l'utilisateur dont on cherche les réservations.
     * @return Une liste de {@link ReservationEntity} correspondant aux réservations de l'utilisateur donné.
     */
    @Query("select r from ReservationEntity r where r.utilisateur.username = ?1")
    ArrayList<ReservationEntity> findReservationByUsername(String username);
}
