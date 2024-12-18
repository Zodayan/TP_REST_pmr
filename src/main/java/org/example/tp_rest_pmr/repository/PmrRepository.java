package org.example.tp_rest_pmr.repository;

import org.example.tp_rest_pmr.entity.PmrEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface Repository pour l'entité {@link PmrEntity}.
 * Cette interface étend {@link JpaRepository} et permet de gérer les opérations de persistance pour les entités {@link PmrEntity}.
 * Elle fournit des méthodes pour accéder aux données de l'entité PMR (Personne à Mobilité Réduite) dans la base de données.
 */
@Repository
public interface PmrRepository extends JpaRepository<PmrEntity, Integer> {

    /**
     * Recherche un objet {@link PmrEntity} par son identifiant.
     *
     * @param id L'identifiant du PMR à rechercher.
     * @return L'entité {@link PmrEntity} correspondante à l'identifiant donné.
     */
    PmrEntity findPmrById(Integer id);
}
