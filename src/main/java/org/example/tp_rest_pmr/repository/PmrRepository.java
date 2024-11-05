package org.example.tp_rest_pmr.repository;

import org.example.tp_rest_pmr.entity.PmrEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PmrRepository extends JpaRepository<PmrEntity, Integer>
{
    public PmrEntity findPmrNomAndDescription(String nom, String description);
}
