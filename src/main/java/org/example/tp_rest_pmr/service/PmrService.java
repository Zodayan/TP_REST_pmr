package org.example.tp_rest_pmr.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.tp_rest_pmr.dto.PmrDTO;
import org.example.tp_rest_pmr.entity.PmrEntity;
import org.example.tp_rest_pmr.mapper.PmrMapper;
import org.example.tp_rest_pmr.repository.PmrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Service pour gérer les opérations liées aux entités {@link PmrEntity}.
 * Ce service fournit des méthodes pour accéder, créer, mettre à jour et supprimer des entités PMR (Personne à Mobilité Réduite).
 */
@Builder
@Getter
@Setter
@Service
public class PmrService {

    private final PmrRepository pmrRepository;
    private final PmrMapper pmrMapper;

    /**
     * Constructeur du service {@link PmrService}.
     *
     * @param pmrRepository Le repository pour accéder aux données de type {@link PmrEntity}.
     * @param pmrMapper Le mapper pour convertir entre {@link PmrEntity} et {@link PmrDTO}.
     */
    @Autowired
    public PmrService(PmrRepository pmrRepository, PmrMapper pmrMapper) {
        this.pmrRepository = pmrRepository;
        this.pmrMapper = pmrMapper;
    }

    /**
     * Récupère toutes les entités PMR et les convertit en objets {@link PmrDTO}.
     *
     * @return Une liste d'objets {@link PmrDTO} représentant toutes les entités PMR.
     */
    public ArrayList<PmrDTO> getAllPmr() {
        ArrayList<PmrDTO> pmrDTOs = new ArrayList<>();
        for (PmrEntity pmrEntity : pmrRepository.findAll()) {
            pmrDTOs.add(pmrMapper.toDTO(pmrEntity));
        }
        return pmrDTOs;
    }

    /**
     * Vérifie si un PMR existe dans la base de données en fonction de son ID.
     *
     * @param id L'ID du PMR à vérifier.
     * @return {@code true} si le PMR existe, {@code false} sinon.
     */
    public boolean isPmrCreate(int id) {
        PmrEntity pmrEntity = pmrRepository.findById(id).orElse(null);
        return pmrEntity != null;
    }

    /**
     * Récupère un PMR en fonction de son ID et le convertit en objet {@link PmrDTO}.
     *
     * @param id L'ID du PMR à récupérer.
     * @return L'objet {@link PmrDTO} correspondant à l'entité PMR.
     * @throws IllegalArgumentException Si le PMR avec l'ID donné n'est pas trouvé.
     */
    public PmrDTO getPmr(Integer id) {
        PmrEntity pmrEntity = pmrRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation with id " + id + " not found"));
        return pmrMapper.toDTO(pmrEntity);
    }

    /**
     * Ajoute un nouveau PMR à la base de données.
     *
     * @param nom Le nom du PMR.
     * @param quantite La quantité du PMR.
     * @param description La description du PMR.
     * @param pointGeo Le point géographique du PMR.
     */
    public void addPmr(String nom, Integer quantite, String description, String pointGeo) {
        PmrEntity pmrEntity = new PmrEntity();
        pmrEntity.setNom(nom);
        pmrEntity.setQuantite(quantite);
        pmrEntity.setDescription(description);
        pmrEntity.setPoint_geo(pointGeo);
        pmrRepository.save(pmrEntity);
    }

    /**
     * Met à jour un PMR existant en fonction de son ID.
     *
     * @param id L'ID du PMR à mettre à jour.
     * @param nom Le nouveau nom du PMR.
     * @param quantite La nouvelle quantité du PMR.
     * @param description La nouvelle description du PMR.
     * @param pointGeo Le nouveau point géographique du PMR.
     * @throws IllegalArgumentException Si le PMR avec l'ID donné n'est pas trouvé.
     */
    public void updatePmr(Integer id, String nom, Integer quantite, String description, String pointGeo) {
        PmrEntity pmrEntity = pmrRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation with id " + id + " not found"));

        pmrEntity.setNom(nom);
        pmrEntity.setQuantite(quantite);
        pmrEntity.setDescription(description);
        pmrEntity.setPoint_geo(pointGeo);
        pmrRepository.save(pmrEntity);
    }

    /**
     * Supprime un PMR de la base de données en fonction de son ID.
     *
     * @param id L'ID du PMR à supprimer.
     * @throws IllegalArgumentException Si le PMR avec l'ID donné n'est pas trouvé.
     */
    public void deletePmr(Integer id) {
        PmrEntity pmrEntity = pmrRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation with id " + id + " not found"));

        pmrRepository.delete(pmrEntity);
    }
}
