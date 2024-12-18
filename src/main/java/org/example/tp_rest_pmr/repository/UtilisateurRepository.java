package org.example.tp_rest_pmr.repository;

import org.example.tp_rest_pmr.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface Repository pour l'entité {@link UtilisateurEntity}.
 * Cette interface étend {@link JpaRepository} et permet de gérer les opérations de persistance pour les entités {@link UtilisateurEntity}.
 * Elle fournit des méthodes pour accéder aux données des utilisateurs dans la base de données.
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Integer> {

    /**
     * Recherche un utilisateur par son identifiant.
     *
     * @param utilisateurId L'identifiant de l'utilisateur à rechercher.
     * @return L'entité {@link UtilisateurEntity} correspondant à l'identifiant donné.
     */
    UtilisateurEntity findUtilisateurById(Integer utilisateurId);
}
