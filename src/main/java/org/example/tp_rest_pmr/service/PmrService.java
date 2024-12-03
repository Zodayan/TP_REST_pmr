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
import java.util.HashSet;
import java.util.Set;


@Builder
@Getter
@Setter
@Service
public class PmrService
{
    private final PmrRepository pmrRepository;
    private final PmrMapper pmrMapper;

    @Autowired
    public PmrService(PmrRepository pmrRepository, PmrMapper pmrMapper) {
        this.pmrRepository = pmrRepository;
        this.pmrMapper = pmrMapper;
    }

    public ArrayList<PmrDTO> getAllPmr()
    {
        ArrayList<PmrDTO> pmrDTOs = new ArrayList<>();
        for (PmrEntity pmrEntity : pmrRepository.findAll())
        {
            pmrDTOs.add(pmrMapper.toDTO(pmrEntity));
        }
        return pmrDTOs;
    }

    public PmrDTO getPmr(Integer id)
    {
        return pmrMapper.toDTO(pmrRepository.findPmrById(id));
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
