package org.example.tp_rest_pmr.service;

import lombok.*;

import java.util.HashSet;
import java.util.Set;
import org.example.tp_rest_pmr.dto.UtilisateurDTO;
import org.example.tp_rest_pmr.entity.UtilisateurEntity;
import org.example.tp_rest_pmr.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Builder
@Getter
@Setter
@Service
public class UtilisateurService
{
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository)
    {
        this.utilisateurRepository = utilisateurRepository;
    }
    
    public Set<UtilisateurDTO> getAllUtilisateurs()
    {
        utilisateurRepository.findAll();
        return new HashSet<UtilisateurDTO>();
    }

    public UtilisateurDTO getUtilisateur(Integer id)
    {
        utilisateurRepository.findById(id);

        return new UtilisateurDTO();
    }
    
    public void addUtilisateur(String nom, String prenom, String email, String username, String password)
    {
        UtilisateurEntity utilisateur = new UtilisateurEntity();
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setMail(email);
        utilisateur.setUsername(username);
        utilisateur.setPassword(password);
        utilisateurRepository.save(utilisateur);
    }

    public void updateUtilisateur(String nom, String prenom, String email, String username, String password)
    {
        UtilisateurEntity utilisateurToUpdate = utilisateurRepository.findByNomAndPrenom(nom, prenom);
        utilisateurToUpdate.setMail(email);
        utilisateurToUpdate.setUsername(username);
        utilisateurToUpdate.setPassword(password);
        utilisateurRepository.updateUtilisateur(utilisateurToUpdate);
    }

    public void deleteUtilisateurByNomAndPrenomAndMail(String nom, String prenom, String email)
    {
        utilisateurRepository.findByNomAndPrenom(nom, prenom);
        utilisateurRepository.deleteByNomAndPrenomAndMail(nom, prenom, email);
    }
}
