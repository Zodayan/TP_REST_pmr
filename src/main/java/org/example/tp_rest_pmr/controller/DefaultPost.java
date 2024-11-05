package org.example.tp_rest_pmr.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ce controller sert de controleur pour le POST par défaut (en cas de requete non valide)
 */
@RestController
public class DefaultPost {

    @PostMapping
    public String post()
    {
        return "Post\nErreur, vous ne devriez pas arriver ici ! (oui c'est une erreur 404)";
    }

}
