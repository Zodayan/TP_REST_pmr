package org.example.tp_rest_pmr.controller;

import org.example.tp_rest_pmr.controller.utilisateur_controller_data.*;
import org.example.tp_rest_pmr.dto.UtilisateurDTO;
import org.example.tp_rest_pmr.entity.UtilisateurEntity;
import org.example.tp_rest_pmr.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RestController
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService)
    {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping(value = "/utilisateur/getAllUtilisateurs")
    public ResponseEntity<ArrayList<UtilisateurDTO>> getAllUtilisateurs()
    {
        return ResponseEntity.ok(utilisateurService.getAllUtilisateurs());
    }

    @GetMapping(value = "/utilisateur/getUtilisateur")
    public ResponseEntity<UtilisateurDTO> getUtilisateur(DataGetUtilisateur data)
    {
        UtilisateurDTO utilisateur = utilisateurService.getUtilisateur(data.getIdUtilisateur());

        if (utilisateur == null)
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok(utilisateur);
        }
    }

    @GetMapping(value = "/utilisateur/isUsernameAvailable")
    public boolean isUsernameAvailable(DataCheckUsername data)
    {
        return utilisateurService.isUsernameAvailable(data.getUsername());
    }

    @GetMapping(value = "/utilisateur/checkLogin")
    public boolean checkLogin(DataCheckLogin data)
    {
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException ignored) {}

        return utilisateurService.checkLogin(data.getUsername(), data.getPassword());
    }

    @PostMapping(value = "/utilisateur/addUtilisateur")
    public ResponseEntity<Response> postAddUtilisateur(@RequestBody DataPostAddUtilisateur data)
    {
        utilisateurService.addUtilisateur(data.getNom(), data.getPrenom(), data.getEmail(), data.getUsername(), data.getPassword());
        return ResponseEntity.ok(new Response("Utilisateur Added"));
    }

    @PutMapping(value = "/utilisateur/updateUtilisateur")
    public ResponseEntity<Response> putUpdateUtilisateur(@RequestBody DataPutUpdateUtilisateur data)
    {
        utilisateurService.updateUtilisateur(data.getId(), data.getNom(), data.getPrenom(), data.getEmail(), data.getUsername(), data.getPrenom());
        return ResponseEntity.ok(new Response("Utilisateur Updated"));
    }

    @DeleteMapping(value = "/utilisateur/deleteUtilisateur")
    public ResponseEntity<Response> deleteUtilisateur(@RequestBody DataDeleteUtilisateur data)
    {
        utilisateurService.deleteUtilisateur(data.getId());
        return ResponseEntity.ok(new Response("Utilisateur Deleted"));
    }
}
