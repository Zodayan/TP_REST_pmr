package org.example.tp_rest_pmr.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.tp_rest_pmr.dto.ReservationDTO;
import org.example.tp_rest_pmr.entity.EmbeddedIdReservation;
import org.example.tp_rest_pmr.entity.PmrEntity;
import org.example.tp_rest_pmr.entity.ReservationEntity;
import org.example.tp_rest_pmr.entity.UtilisateurEntity;
import org.example.tp_rest_pmr.mapper.ReservationMapper;
import org.example.tp_rest_pmr.mapper.UtilisateurMapper;
import org.example.tp_rest_pmr.repository.PmrRepository;
import org.example.tp_rest_pmr.repository.ReservationRepository;
import org.example.tp_rest_pmr.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final UtilisateurRepository utilisateurRepository;
    private final PmrRepository pmrRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper, UtilisateurRepository utilisateurRepository, PmrRepository pmrRepository) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.utilisateurRepository = utilisateurRepository;
        this.pmrRepository = pmrRepository;
    }

    public ArrayList<ReservationDTO> getAllReservationsByUsername(String username) {
        ArrayList<ReservationDTO> reservations = new ArrayList<>();
        for(ReservationEntity reservation : reservationRepository.findAll())
        {
            if (reservation.getUtilisateur().getUsername().equals(username)) {

                reservations.add(reservationMapper.toDTO(reservation));
            }
        }
        return reservations;
    }

    public ArrayList<ReservationDTO> getAllReservations()
    {
        ArrayList<ReservationDTO> reservations = new ArrayList<>();
        for(ReservationEntity reservation : reservationRepository.findAll())
        {
            reservations.add(reservationMapper.toDTO(reservation));
        }
        return reservations;
    }

    public ReservationDTO getReservationById(Integer pmrId, Integer utilisateurId)
    {
        ReservationEntity reservation = reservationRepository.findById(new EmbeddedIdReservation(pmrId, utilisateurId))
                .orElseThrow(() -> new IllegalArgumentException("Reservation with pmrId " + pmrId + " and utilisateurId " + utilisateurId + " not found"));

        return reservationMapper.toDTO(reservation);
    }

    public void addReservation(Integer pmrId, Integer utilisateurId, Integer reservation)
    {
        PmrEntity associatedPmr = pmrRepository.findById(pmrId)
                .orElseThrow(() -> new RuntimeException("pmrId " + pmrId + " must be a valid id for pmr"));
        UtilisateurEntity associatedUtilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("utilisateurId " + utilisateurId + " must be a valid id for utilisateur"));

        ReservationEntity nouvelleReservation = ReservationEntity.builder()
                        .id(new EmbeddedIdReservation(associatedPmr.getId(), associatedUtilisateur.getId()))
                        .reservation(reservation)
                        .pmr(associatedPmr)
                        .utilisateur(associatedUtilisateur)
                        .build();

        reservationRepository.save(nouvelleReservation);
    }

    public void updateReservation(Integer pmrId, Integer utilisateurId, Integer reservation)
    {
        ReservationEntity reservationToUpdate = reservationRepository.findById(new EmbeddedIdReservation(pmrId, utilisateurId))
                .orElseThrow(() -> new IllegalArgumentException("Reservation with pmrId " + pmrId + " and utilisateurId " + utilisateurId + " not found"));

        reservationToUpdate.setReservation(reservation);
        reservationRepository.save(reservationToUpdate);
    }

    public void deleteReservation(Integer pmrId, Integer utilisateurId)
    {
        ReservationEntity reservationToDelete = reservationRepository.findById(new EmbeddedIdReservation(pmrId, utilisateurId))
                .orElseThrow(() -> new IllegalArgumentException("Reservation with pmrId " + pmrId + " and utilisateurId " + utilisateurId + " not found"));

        reservationRepository.delete(reservationToDelete);
    }
}
