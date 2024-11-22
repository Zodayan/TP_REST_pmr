package org.example.tp_rest_pmr.controller;

import org.example.tp_rest_pmr.controller.reservation_controller_data.DataGetReservation;
import org.example.tp_rest_pmr.controller.reservation_controller_data.DataPostAddReservation;
import org.example.tp_rest_pmr.controller.reservation_controller_data.DataDeleteReservation;
import org.example.tp_rest_pmr.controller.reservation_controller_data.DataPutUpdateReservation;
import org.example.tp_rest_pmr.dto.ReservationDTO;
import org.example.tp_rest_pmr.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ReservationController
{

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(value = "/reservation/getAllReservations")
    public ResponseEntity<Set<ReservationDTO>> getAllReservations()
    {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping(value = "/reservation/getReservation")
    public ResponseEntity<ReservationDTO> getReservation(DataGetReservation data)
    {

        return ResponseEntity.ok(reservationService.getReservationById(data.getPmrId(), data.getUtilisateurId()));
    }

    @PostMapping(value = "/reservation/addReservation")
    public void postAddReservation(@RequestBody DataPostAddReservation data)
    {
        reservationService.addReservation(data.getPmrId(), data.getUtilisateurId(), data.getReservation());
    }

    @PutMapping(value = "/reservation/updateReservation")
    public void putUpdateReservation(@RequestBody DataPutUpdateReservation data)
    {
        reservationService.updateReservation(data.getPmrId(), data.getUtilisateurId(), data.getReservation());
    }

    @DeleteMapping(value = "/reservation/updateReservation")
    public void deleteReservation(@RequestBody DataDeleteReservation data)
    {
        reservationService.deleteReservation(data.getPmrId(), data.getUtilisateurId());
    }
}
