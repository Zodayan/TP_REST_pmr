package org.example.tp_rest_pmr.service;

import lombok.*;

import java.util.ArrayList;
import org.example.tp_rest_pmr.dto.UtilisateurDTO;
import org.example.tp_rest_pmr.entity.UtilisateurEntity;
import org.example.tp_rest_pmr.mapper.UtilisateurMapper;
import org.example.tp_rest_pmr.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public int getIdByLogin(String username, String password){
        ArrayList<UtilisateurDTO> users = getAllUtilisateurs();
        for (UtilisateurDTO user : users){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user.getId();
            }
        }
        return -1;
    }

    public ArrayList<UtilisateurDTO> getAllUtilisateurs()
    {
        ArrayList<UtilisateurDTO> utilisateurs = new ArrayList<>();
        for (UtilisateurEntity utilisateurEntity : utilisateurRepository.findAll())
        {
            utilisateurs.add(utilisateurMapper.toDTO(utilisateurEntity));
        }
        return utilisateurs;
    }

    public UtilisateurDTO getUtilisateur(Integer id)
    {
        UtilisateurEntity utilisateurEntity = utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur with id " + id + " not found"));

        return utilisateurMapper.toDTO(utilisateurEntity);
    }

    public Integer getIdbyUsername(String username)
    {
        for (UtilisateurEntity utilisateurEntity : utilisateurRepository.findAll()){
            if (utilisateurEntity.getUsername().equals(username)){
                return utilisateurEntity.getId();
            }
        }
        return -1;
    }
    public boolean isUsernameAvailable(String username)
    {
        boolean isAvailable = true;
        for (UtilisateurEntity utilisateurEntity : utilisateurRepository.findAll()){
            if (utilisateurEntity.getUsername().equals(username)){
                isAvailable = false;
            }
        }
        return isAvailable;
    }

    public boolean checkLogin(String username, String password)
    {
        for (UtilisateurEntity utilisateurEntity : utilisateurRepository.findAll()){
            if (utilisateurEntity.getUsername().equals(username)){
                return utilisateurEntity.getPassword().equals(password);
            }
        }
        return false;
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
        UtilisateurEntity utilisateurToUpdate = utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur with id " + id + " not found"));

        utilisateurToUpdate.setNom(nom);
        utilisateurToUpdate.setPrenom(prenom);
        utilisateurToUpdate.setMail(email);
        utilisateurToUpdate.setUsername(username);
        utilisateurToUpdate.setPassword(password);
        utilisateurRepository.save(utilisateurToUpdate);
    }

    public void deleteUtilisateur(Integer idUtilisateur)
    {
        UtilisateurEntity utilisateurToDelete =utilisateurRepository.findById(idUtilisateur)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur with id " + idUtilisateur + " not found"));

        utilisateurRepository.delete(utilisateurToDelete);
    }

    public int getUserIdByusername(@NonNull String username) {
        for (UtilisateurEntity utilisateurEntity : utilisateurRepository.findAll()){
            if (utilisateurEntity.getUsername().equals(username)){
                return utilisateurEntity.getId();
            }
        }
        return -1;
    }
}
