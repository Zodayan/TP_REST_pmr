package org.example.tp_rest_pmr.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.tp_rest_pmr.dto.ReservationDTO;
import org.example.tp_rest_pmr.entity.EmbeddedIdReservation;
import org.example.tp_rest_pmr.entity.ReservationEntity;
import org.example.tp_rest_pmr.mapper.ReservationMapper;
import org.example.tp_rest_pmr.mapper.UtilisateurMapper;
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

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
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
        return reservationMapper.toDTO(reservationRepository.findReservationById(new EmbeddedIdReservation(pmrId, utilisateurId)));
    }

    public void addReservation(Integer pmrId, Integer utilisateurId, Integer reservation)
    {
        ReservationEntity nouvelleReservation = new ReservationEntity();
        nouvelleReservation.setId(new EmbeddedIdReservation(pmrId, utilisateurId));
        nouvelleReservation.setReservation(reservation);
        reservationRepository.save(nouvelleReservation);
    }

    public void updateReservation(Integer pmrId, Integer utilisateurId, Integer reservation)
    {
        ReservationEntity reservationToUpdate = reservationRepository.findById(new EmbeddedIdReservation(pmrId, utilisateurId)).get();
        reservationToUpdate.setReservation(reservation);
        reservationRepository.save(reservationToUpdate);
    }

    public void deleteReservation(Integer pmrId, Integer utilisateurId)
    {
        reservationRepository.delete(reservationRepository.findById(new EmbeddedIdReservation(pmrId, utilisateurId)).get());
    }
}
