package org.example.tp_rest_pmr.controller;

import org.example.tp_rest_pmr.controller.reservation_controller_data.*;
import org.example.tp_rest_pmr.dto.ReservationDTO;
import org.example.tp_rest_pmr.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@RestController
public class ReservationController
{

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(value = "/reservation/getAllReservationsByUsername")
    public ResponseEntity<ArrayList<ReservationDTO>> getAllReservationsByUsername(DataGetReservationByUsername data)
    {
        return ResponseEntity.ok(reservationService.getAllReservationsByUsername(data.getUsername()));
    }

    @GetMapping(value = "/reservation/getAllReservations")
    public ResponseEntity<ArrayList<ReservationDTO>> getAllReservations()
    {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping(value = "/reservation/getReservation")
    public ResponseEntity<ReservationDTO> getReservation(DataGetReservation data)
    {
        try {
            ReservationDTO reservation = reservationService.getReservationById(data.getPmrId(), data.getUtilisateurId());
            return ResponseEntity.ok(reservation);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/reservation/addReservation")
    public ResponseEntity<Response> postAddReservation(@RequestBody DataPostAddReservation data)
    {
        try {
            reservationService.addReservation(data.getPmrId(), data.getUtilisateurId(), data.getReservation());
            return ResponseEntity.ok(new Response("Reservation Added"));
        }
        catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/reservation/updateReservation")
    public ResponseEntity<Response> putUpdateReservation(@RequestBody DataPutUpdateReservation data)
    {
        try {
            reservationService.updateReservation(data.getPmrId(), data.getUtilisateurId(), data.getReservation());
            return ResponseEntity.ok(new Response("Reservation Updated"));
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/reservation/deleteReservation/{idUtilisateur}/{idPmr}")
    public ResponseEntity<Response> deleteReservation(@PathVariable Integer idUtilisateur, @PathVariable Integer idPmr)
    {
        try {
            reservationService.deleteReservation(idPmr, idUtilisateur);
            return ResponseEntity.ok(new Response("Reservation Deleted"));
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
