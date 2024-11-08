package org.example.tp_rest_pmr.service;

import lombok.*;

import java.util.HashSet;
import java.util.Set;
import org.example.tp_rest_pmr.dto.UtilisateurDTO;
import org.example.tp_rest_pmr.entity.UtilisateurEntity;
import org.example.tp_rest_pmr.mapper.UtilisateurMapper;
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
    private final UtilisateurMapper utilisateurMapper;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper)
    {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMapper = utilisateurMapper;
    }

    public Set<UtilisateurDTO> getAllUtilisateurs()
    {
        HashSet<UtilisateurDTO> utilisateurs = new HashSet<>();
        for (UtilisateurEntity utilisateurEntity : utilisateurRepository.findAll())
        {
            utilisateurs.add(utilisateurMapper.toDTO(utilisateurEntity));
        }
        return utilisateurs;
    }

    public UtilisateurDTO getUtilisateur(Integer id)
    {
        utilisateurRepository.findById(id);

        return utilisateurMapper.toDTO(utilisateurRepository.findById(id).get());
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

    public void updateUtilisateur(Integer id, String nom, String prenom, String email, String username, String password)
    {
        UtilisateurEntity utilisateurToUpdate = utilisateurRepository.findById(id).get();
        utilisateurToUpdate.setNom(nom);
        utilisateurToUpdate.setPrenom(prenom);
        utilisateurToUpdate.setMail(email);
        utilisateurToUpdate.setUsername(username);
        utilisateurToUpdate.setPassword(password);
        utilisateurRepository.save(utilisateurToUpdate);
    }

    public void deleteUtilisateur(Integer idUtilisateur)
    {
        utilisateurRepository.delete(utilisateurRepository.findById(idUtilisateur).get());
    }
}
