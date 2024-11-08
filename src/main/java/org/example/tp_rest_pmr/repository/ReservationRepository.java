package org.example.tp_rest_pmr.repository;

import org.example.tp_rest_pmr.entity.EmbeddedIdReservation;
import org.example.tp_rest_pmr.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, EmbeddedIdReservation>
{
    ReservationEntity findReservationById(EmbeddedIdReservation embeddedIdReservation);
}
