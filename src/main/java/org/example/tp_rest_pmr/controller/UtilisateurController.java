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
    public ResponseEntity<UtilisateurDTO> getUtilisateur(@RequestBody DataGetUtilisateur data)
    {
        try {
            UtilisateurDTO utilisateur = utilisateurService.getUtilisateur(data.getIdUtilisateur());
            return ResponseEntity.ok(utilisateur);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/utilisateur/isUsernameAvailable")
    public boolean isUsernameAvailable(@RequestBody DataCheckUsername data)
    {
        return utilisateurService.isUsernameAvailable(data.getUsername());
    }

    @GetMapping(value = "/utilisateur/checkLogin")
    public boolean checkLogin(DataCheckLogin data)
    {
        return utilisateurService.checkLogin(data.getUsername(), data.getPassword());
    }

    @GetMapping(value = "/utilisateur/getUserIdByusername")
    public ResponseEntity<UtilisateurDTO> getUserIdByusername(@RequestBody DataGetUserByUsername data)
    {
        int id = utilisateurService.getIdbyUsername(data.getUsername());
        if (id == -1){
            return ResponseEntity.notFound().build();
        }

        UtilisateurDTO utilisateur = utilisateurService.getUtilisateur(id);

        if (utilisateur == null)
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok(utilisateur);
        }
    }

    @PostMapping(value = "/utilisateur/addUtilisateur")
    public ResponseEntity<Response> postAddUtilisateur(@RequestBody DataPostAddUtilisateur data)
    {
        utilisateurService.addUtilisateur(data.getNom(), data.getPrenom(), data.getMail(), data.getUsername(), data.getPassword());
        return ResponseEntity.ok(new Response("Utilisateur Added"));
    }

    @PostMapping(value = "/utilisateur/getUtilisateurByLogin")
    public ResponseEntity<UtilisateurDTO> getUtilisateurByLogin(@RequestBody DataPostGetUtilisateurLogin data)
    {
        int id = utilisateurService.getIdByLogin(data.getUsername(), data.getPassword());
        if (id == -1){
            return ResponseEntity.notFound().build();
        }

        UtilisateurDTO utilisateur = utilisateurService.getUtilisateur(id);

        if (utilisateur == null)
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok(utilisateur);
        }
    }

    @PutMapping(value = "/utilisateur/updateUtilisateur")
    public ResponseEntity<Response> putUpdateUtilisateur(@RequestBody DataPutUpdateUtilisateur data)
    {
        int id = utilisateurService.getIdByLogin(data.getCurrentUsername(),data.getCurrentPassword());
        if (id == -1){
            return ResponseEntity.notFound().build();
        }

        try {
            utilisateurService.updateUtilisateur(id, data.getNom(), data.getPrenom(), data.getMail(), data.getUsername(), data.getPassword());
            return ResponseEntity.ok(new Response("Utilisateur Updated"));
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/utilisateur/deleteUtilisateur")
    public ResponseEntity<Response> deleteUtilisateur(@RequestBody DataDeleteUtilisateur data)
    {
        try {
            utilisateurService.deleteUtilisateur(data.getId());
            return ResponseEntity.ok(new Response("Utilisateur Deleted"));
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
