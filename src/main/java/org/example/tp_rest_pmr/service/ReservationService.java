package org.example.tp_rest_pmr.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.tp_rest_pmr.repository.ReservationRepository;
import org.example.tp_rest_pmr.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Builder
@Getter
@Setter
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
}
