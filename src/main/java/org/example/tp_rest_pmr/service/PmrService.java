package org.example.tp_rest_pmr.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.tp_rest_pmr.dto.PmrDTO;
import org.example.tp_rest_pmr.entity.PmrEntity;
import org.example.tp_rest_pmr.repository.PmrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Builder
@Getter
@Setter
@Service
public class PmrService {

    private final PmrRepository pmrRepository;

    @Autowired
    public PmrService(PmrRepository pmrRepository) {
        this.pmrRepository = pmrRepository;
    }

    public Set<PmrDTO> getAllPmr()
    {
        pmrRepository.findAll();
        return new HashSet<>();
    }

    public PmrDTO getPmr(String nom, String description)
    {
        pmrRepository.findPmrByNomAndDescription(nom, description);
        return new PmrDTO();
    }

    public void addPmr(String nom, Integer quantite, String description, String pointGeo)
    {
        PmrEntity pmrEntity = new PmrEntity();
        pmrEntity.setNom(nom);
        pmrEntity.setQuantite(quantite);
        pmrEntity.setDescription(description);
        pmrEntity.setPoint_geo(pointGeo);
        pmrRepository.save(pmrEntity);
    }

    public void updatePmr(String nom, Integer quantite, String description, String pointGeo)
    {
        PmrEntity pmrEntity = pmrRepository.findPmrByNomAndDescription(nom, description);
        pmrEntity.setQuantite(quantite);
        pmrEntity.setDescription(description);
        pmrEntity.setPoint_geo(pointGeo);
        pmrRepository.save(pmrEntity);
    }

    public void deletePmr(String nom, String description)
    {
        pmrRepository.findPmrByNomAndDescription(nom, description);
        pmrRepository.delete(pmrRepository.findPmrByNomAndDescription(nom, description));
    }
}
