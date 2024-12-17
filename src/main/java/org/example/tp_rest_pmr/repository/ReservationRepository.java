package org.example.tp_rest_pmr.repository;

import org.example.tp_rest_pmr.entity.EmbeddedIdReservation;
import org.example.tp_rest_pmr.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, EmbeddedIdReservation>
{
    ReservationEntity findReservationById(EmbeddedIdReservation embeddedIdReservation);

    @Query("select r from ReservationEntity r where r.utilisateur.username = ?1")
    ArrayList<ReservationEntity> findReservationByUsername(String username);
}
