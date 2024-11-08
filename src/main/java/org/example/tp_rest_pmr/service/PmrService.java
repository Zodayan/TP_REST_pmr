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
        return new HashSet<PmrDTO>();
    }

    public PmrDTO getPmr(Integer id)
    {
        pmrRepository.findPmrById(id);
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

    public void updatePmr(Integer id,String Nom, Integer quantite, String description, String pointGeo)
    {
        PmrEntity pmrEntity = pmrRepository.findPmrById(id);
        pmrEntity.setNom(Nom);
        pmrEntity.setQuantite(quantite);
        pmrEntity.setDescription(description);
        pmrEntity.setPoint_geo(pointGeo);
        pmrRepository.save(pmrEntity);
    }

    public void deletePmr(Integer id)
    {
        pmrRepository.delete(pmrRepository.findPmrById(id));
    }
}
