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

/**
 * Service pour gérer les opérations liées aux réservations.
 * Ce service fournit des méthodes pour récupérer, créer, mettre à jour et supprimer des réservations.
 */
@Builder
@Getter
@Setter
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final UtilisateurRepository utilisateurRepository;
    private final PmrRepository pmrRepository;

    /**
     * Constructeur du service {@link ReservationService}.
     *
     * @param reservationRepository Le repository pour accéder aux données de type {@link ReservationEntity}.
     * @param reservationMapper Le mapper pour convertir entre {@link ReservationEntity} et {@link ReservationDTO}.
     * @param utilisateurRepository Le repository pour accéder aux données des utilisateurs.
     * @param pmrRepository Le repository pour accéder aux données des PMR.
     */
    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper, UtilisateurRepository utilisateurRepository, PmrRepository pmrRepository) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.utilisateurRepository = utilisateurRepository;
        this.pmrRepository = pmrRepository;
    }

    /**
     * Récupère toutes les réservations d'un utilisateur spécifique par son nom d'utilisateur.
     *
     * @param username Le nom d'utilisateur pour filtrer les réservations.
     * @return Une liste d'objets {@link ReservationDTO} représentant les réservations de l'utilisateur.
     */
    public ArrayList<ReservationDTO> getAllReservationsByUsername(String username) {
        ArrayList<ReservationDTO> reservations = new ArrayList<>();
        for(ReservationEntity reservation : reservationRepository.findAll()) {
            if (reservation.getUtilisateur().getUsername().equals(username)) {
                reservations.add(reservationMapper.toDTO(reservation));
            }
        }
        return reservations;
    }

    /**
     * Récupère toutes les réservations.
     *
     * @return Une liste d'objets {@link ReservationDTO} représentant toutes les réservations.
     */
    public ArrayList<ReservationDTO> getAllReservations() {
        ArrayList<ReservationDTO> reservations = new ArrayList<>();
        for(ReservationEntity reservation : reservationRepository.findAll()) {
            reservations.add(reservationMapper.toDTO(reservation));
        }
        return reservations;
    }

    /**
     * Récupère une réservation spécifique par les identifiants PMR et utilisateur.
     *
     * @param pmrId L'ID du PMR associé à la réservation.
     * @param utilisateurId L'ID de l'utilisateur associé à la réservation.
     * @return Un objet {@link ReservationDTO} représentant la réservation.
     * @throws IllegalArgumentException Si la réservation avec les identifiants fournis n'est pas trouvée.
     */
    public ReservationDTO getReservationById(Integer pmrId, Integer utilisateurId) {
        ReservationEntity reservation = reservationRepository.findById(new EmbeddedIdReservation(pmrId, utilisateurId))
                .orElseThrow(() -> new IllegalArgumentException("Reservation with pmrId " + pmrId + " and utilisateurId " + utilisateurId + " not found"));
        return reservationMapper.toDTO(reservation);
    }

    /**
     * Ajoute une nouvelle réservation dans la base de données.
     *
     * @param pmrId L'ID du PMR associé à la réservation.
     * @param utilisateurId L'ID de l'utilisateur associé à la réservation.
     * @param reservation La quantité de la réservation.
     * @throws RuntimeException Si l'ID du PMR ou de l'utilisateur est invalide.
     */
    public void addReservation(Integer pmrId, Integer utilisateurId, Integer reservation) {
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

    /**
     * Met à jour une réservation existante.
     *
     * @param pmrId L'ID du PMR associé à la réservation.
     * @param utilisateurId L'ID de l'utilisateur associé à la réservation.
     * @param reservation La nouvelle quantité de la réservation.
     * @throws IllegalArgumentException Si la réservation avec les identifiants fournis n'est pas trouvée.
     */
    public void updateReservation(Integer pmrId, Integer utilisateurId, Integer reservation) {
        ReservationEntity reservationToUpdate = reservationRepository.findById(new EmbeddedIdReservation(pmrId, utilisateurId))
                .orElseThrow(() -> new IllegalArgumentException("Reservation with pmrId " + pmrId + " and utilisateurId " + utilisateurId + " not found"));

        reservationToUpdate.setReservation(reservation);
        reservationRepository.save(reservationToUpdate);
    }

    /**
     * Supprime une réservation en fonction des identifiants PMR et utilisateur.
     *
     * @param pmrId L'ID du PMR associé à la réservation.
     * @param utilisateurId L'ID de l'utilisateur associé à la réservation.
     * @throws IllegalArgumentException Si la réservation avec les identifiants fournis n'est pas trouvée.
     */
    public void deleteReservation(Integer pmrId, Integer utilisateurId) {
        ReservationEntity reservationToDelete = reservationRepository.findById(new EmbeddedIdReservation(pmrId, utilisateurId))
                .orElseThrow(() -> new IllegalArgumentException("Reservation with pmrId " + pmrId + " and utilisateurId " + utilisateurId + " not found"));

        reservationRepository.delete(reservationToDelete);
    }
}
