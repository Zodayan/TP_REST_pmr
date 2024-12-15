package org.example.tp_rest_pmr.repository;

import org.example.tp_rest_pmr.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Integer>
{
    UtilisateurEntity findUtilisateurById(Integer utilisateurId);
    // Pas besoin de faire le code des méthodes, Spring s'occupe de le faire en
    // déduisant du nom de la méthode (voir "derived query methods Spring")
}
