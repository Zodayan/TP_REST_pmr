package org.example.tp_rest_pmr.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.tp_rest_pmr.entity.ReservationEntity;
import org.example.tp_rest_pmr.repository.ReservationRepository;
import org.example.tp_rest_pmr.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

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
    public String getAllReservations() { return "ça fait des trucs"; }
    public String getReservationById(Integer pmrId, Integer utilisateurId){ return "ça fait des trucs"; }
    public String addReservation(Integer pmrId, Integer utilisateurId, String nomUtilisateur, String prenomUtilisateur, String nomPmr, String descritption) {return "ça fait des trucs";}
    public String updateReservation(Integer pmrId, Integer utilisateurId, String nomUtilisateur, String prenomUtilisateur, String nomPmr, String descritption, Integer reservation) {return "ça fait des trucs";}
    public String deleteReservation(Integer pmrId, Integer utilisateurId) { return "ça fait des trucs"; }
}
