package org.example.tp_rest_pmr.controller;

import org.example.tp_rest_pmr.controller.utilisateur_controller_data.DataGetUtilisateur;
import org.example.tp_rest_pmr.controller.utilisateur_controller_data.DataPostAddUtilisateur;
import org.example.tp_rest_pmr.controller.utilisateur_controller_data.DataPostDeleteUtilisateur;
import org.example.tp_rest_pmr.controller.utilisateur_controller_data.DataPostUpdateUtilisateur;
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
        return "addUtilisateur " + data;
    }

    @PostMapping(value = "/utilisateur", params = "action=updateUtilisateur")
    public String postUpdateUtilisateur(@RequestBody DataPostUpdateUtilisateur data)
    {
        return "updateUtilisateur " + data;
    }

    @PostMapping(value = "/utilisateur", params = "action=deleteUtilisateur")
    public String postDeleteUtilisateur(@RequestBody DataPostDeleteUtilisateur data)
    {
        return "deleteUtilisateur" + data;
    }
}
