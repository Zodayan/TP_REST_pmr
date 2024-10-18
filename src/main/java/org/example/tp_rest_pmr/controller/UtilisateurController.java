package org.example.tp_rest_pmr.controller;

import org.example.tp_rest_pmr.controller.controller_data.DataGetUtilisateur;
import org.example.tp_rest_pmr.controller.controller_data.DataPostAddUtilisateur;
import org.springframework.web.bind.annotation.*;

@RestController
public class UtilisateurController {

    @GetMapping(value = "/utilisateur", params = "action=getAllUtilisateurs")
    public String getAllUtilisateurs()
    {
        return "getAllUtilisateurs";
    }

    @GetMapping(value = "/utilisateur", params = "action=getUtilisateur")
    public String getUtilisateur(DataGetUtilisateur data)
    {
        return "getUtilisateur " + data.getIdUtilisateur();
    }

    @PostMapping(value = "/utilisateur", params = "action=addUtilisateur")
    public String postAddUtilisateur(@RequestBody DataPostAddUtilisateur data)
    {
        return "getUtilisateur " + data;
    }
}
