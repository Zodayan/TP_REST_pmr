package org.example.tp_rest_pmr.service;

import lombok.*;
import org.example.tp_rest_pmr.dto.UtilisateurDTO;
import org.example.tp_rest_pmr.entity.UtilisateurEntity;
import org.example.tp_rest_pmr.mapper.UtilisateurMapper;
import org.example.tp_rest_pmr.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Service pour gérer les opérations liées aux utilisateurs.
 * Ce service fournit des méthodes pour récupérer, créer, mettre à jour et supprimer des utilisateurs,
 * ainsi que pour vérifier la disponibilité d'un nom d'utilisateur et valider les identifiants de connexion.
 */
@Builder
@Getter
@Setter
@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;

    /**
     * Constructeur du service {@link UtilisateurService}.
     *
     * @param utilisateurRepository Le repository pour accéder aux données des utilisateurs.
     * @param utilisateurMapper Le mapper pour convertir entre {@link UtilisateurEntity} et {@link UtilisateurDTO}.
     */
    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMapper = utilisateurMapper;
    }

    /**
     * Récupère l'ID d'un utilisateur en fonction de son nom d'utilisateur et de son mot de passe.
     *
     * @param username Le nom d'utilisateur.
     * @param password Le mot de passe.
     * @return L'ID de l'utilisateur si les informations de connexion sont correctes, sinon -1.
     */
    public int getIdByLogin(String username, String password) {
        ArrayList<UtilisateurDTO> users = getAllUtilisateurs();
        for (UtilisateurDTO user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user.getId();
            }
        }
        return -1;
    }

    /**
     * Récupère tous les utilisateurs.
     *
     * @return Une liste d'objets {@link UtilisateurDTO} représentant tous les utilisateurs.
     */
    public ArrayList<UtilisateurDTO> getAllUtilisateurs() {
        ArrayList<UtilisateurDTO> utilisateurs = new ArrayList<>();
        for (UtilisateurEntity utilisateurEntity : utilisateurRepository.findAll()) {
            utilisateurs.add(utilisateurMapper.toDTO(utilisateurEntity));
        }
        return utilisateurs;
    }

    /**
     * Récupère un utilisateur spécifique par son ID.
     *
     * @param id L'ID de l'utilisateur à récupérer.
     * @return Un objet {@link UtilisateurDTO} représentant l'utilisateur.
     * @throws IllegalArgumentException Si l'utilisateur avec l'ID fourni n'est pas trouvé.
     */
    public UtilisateurDTO getUtilisateur(Integer id) {
        UtilisateurEntity utilisateurEntity = utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur with id " + id + " not found"));

        return utilisateurMapper.toDTO(utilisateurEntity);
    }

    /**
     * Vérifie si un nom d'utilisateur est disponible.
     *
     * @param username Le nom d'utilisateur à vérifier.
     * @return true si le nom d'utilisateur est disponible, sinon false.
     */
    public boolean isUsernameAvailable(String username) {
        for (UtilisateurEntity utilisateurEntity : utilisateurRepository.findAll()) {
            if (utilisateurEntity.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Vérifie si un nom d'utilisateur et un mot de passe sont valides pour un utilisateur.
     *
     * @param username Le nom d'utilisateur.
     * @param password Le mot de passe.
     * @return true si les identifiants sont valides, sinon false.
     */
    public boolean checkLogin(String username, String password) {
        for (UtilisateurEntity utilisateurEntity : utilisateurRepository.findAll()) {
            if (utilisateurEntity.getUsername().equals(username)) {
                return utilisateurEntity.getPassword().equals(password);
            }
        }
        return false;
    }

    /**
     * Crée un nouvel utilisateur et l'ajoute à la base de données.
     *
     * @param nom Le nom de l'utilisateur.
     * @param prenom Le prénom de l'utilisateur.
     * @param email L'email de l'utilisateur.
     * @param username Le nom d'utilisateur.
     * @param password Le mot de passe.
     */
    public void addUtilisateur(String nom, String prenom, String email, String username, String password) {
        UtilisateurEntity utilisateur = new UtilisateurEntity();
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setMail(email);
        utilisateur.setUsername(username);
        utilisateur.setPassword(password);
        utilisateurRepository.save(utilisateur);
    }

    /**
     * Met à jour les informations d'un utilisateur.
     *
     * @param id L'ID de l'utilisateur à mettre à jour.
     * @param nom Le nom de l'utilisateur.
     * @param prenom Le prénom de l'utilisateur.
     * @param email L'email de l'utilisateur.
     * @param username Le nom d'utilisateur.
     * @param password Le mot de passe.
     * @throws IllegalArgumentException Si l'utilisateur avec l'ID fourni n'est pas trouvé.
     */
    public void updateUtilisateur(Integer id, String nom, String prenom, String email, String username, String password) {
        UtilisateurEntity utilisateurToUpdate = utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur with id " + id + " not found"));

        utilisateurToUpdate.setNom(nom);
        utilisateurToUpdate.setPrenom(prenom);
        utilisateurToUpdate.setMail(email);
        utilisateurToUpdate.setUsername(username);
        utilisateurToUpdate.setPassword(password);
        utilisateurRepository.save(utilisateurToUpdate);
    }

    /**
     * Supprime un utilisateur de la base de données.
     *
     * @param idUtilisateur L'ID de l'utilisateur à supprimer.
     * @throws IllegalArgumentException Si l'utilisateur avec l'ID fourni n'est pas trouvé.
     */
    public void deleteUtilisateur(Integer idUtilisateur) {
        UtilisateurEntity utilisateurToDelete = utilisateurRepository.findById(idUtilisateur)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur with id " + idUtilisateur + " not found"));

        utilisateurRepository.delete(utilisateurToDelete);
    }

    /**
     * Récupère l'ID d'un utilisateur en fonction de son nom d'utilisateur.
     *
     * @param username Le nom d'utilisateur.
     * @return L'ID de l'utilisateur si le nom d'utilisateur est trouvé, sinon -1.
     */
    public int getUserIdByusername(String username) {
        for (UtilisateurEntity utilisateurEntity : utilisateurRepository.findAll()) {
            if (utilisateurEntity.getUsername().equals(username)) {
                return utilisateurEntity.getId();
            }
        }
        return -1;
    }
}
