package org.example.tp_rest_pmr.controller;

import org.example.tp_rest_pmr.controller.utilisateur_controller_data.DataGetUtilisateur;
import org.example.tp_rest_pmr.controller.utilisateur_controller_data.DataPostAddUtilisateur;
import org.example.tp_rest_pmr.controller.utilisateur_controller_data.DataDeleteUtilisateur;
import org.example.tp_rest_pmr.controller.utilisateur_controller_data.DataPutUpdateUtilisateur;
import org.example.tp_rest_pmr.dto.UtilisateurDTO;
import org.example.tp_rest_pmr.entity.UtilisateurEntity;
import org.example.tp_rest_pmr.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Set<UtilisateurDTO>> getAllUtilisateurs()
    {
        return ResponseEntity.ok(utilisateurService.getAllUtilisateurs());
    }

    @GetMapping(value = "/utilisateur/getUtilisateur")
    public ResponseEntity<UtilisateurDTO> getUtilisateur(DataGetUtilisateur data)
    {
        return ResponseEntity.ok(utilisateurService.getUtilisateur(data.getIdUtilisateur()));
    }

    @PostMapping(value = "/utilisateur/addUtilisateur")
    public String postAddUtilisateur(@RequestBody DataPostAddUtilisateur data)
    {
        utilisateurService.addUtilisateur(data.getNom(), data.getPrenom(), data.getEmail(), data.getUsername(), data.getPassword());
        return "User added";
    }

    @PutMapping(value = "/utilisateur/updateUtilisateur")
    public String putUpdateUtilisateur(@RequestBody DataPutUpdateUtilisateur data)
    {
        utilisateurService.updateUtilisateur(data.getId(), data.getNom(), data.getPrenom(), data.getEmail(), data.getUsername(), data.getPrenom());
        return "Updated User";
    }

    @DeleteMapping(value = "/utilisateur/deleteUtilisateur")
    public String deleteUtilisateur(@RequestBody DataDeleteUtilisateur data)
    {
        utilisateurService.deleteUtilisateur(data.getId());
        return "User deleted";
    }
}
