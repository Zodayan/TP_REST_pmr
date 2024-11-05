package org.example.tp_rest_pmr.repository;

import org.example.tp_rest_pmr.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Integer>
{
    // ICI ON VA METTRE LES OPERATIONS CRUD. C'est ici que l'on va faire la logique métier et travailler sur la BDD
}
