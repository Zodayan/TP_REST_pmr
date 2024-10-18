package org.example.tp_rest_pmr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Ce controller sert de controleur pour le GET par défaut (en cas de requete non valide)
 */
@RestController
public class DefaultGet {

    @GetMapping
    public String get()
    {
        return "Get\nErreur, vous ne devriez pas arriver ici ! (oui c'est une erreur 404)";
    }
}
