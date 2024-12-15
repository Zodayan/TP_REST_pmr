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

    @GetMapping(value = "/reservation/getAllReservations")
    public ResponseEntity<ArrayList<ReservationDTO>> getAllReservations()
    {System.out.println("aled");

        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping(value = "/reservation/getReservation")
    public ResponseEntity<ReservationDTO> getReservation(DataGetReservation data)
    {
        ReservationDTO reservation = reservationService.getReservationById(data.getPmrId(), data.getUtilisateurId());

        if (reservation == null)
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok(reservation);
        }
    }

    @PostMapping(value = "/reservation/addReservation")
    public ResponseEntity<Response> postAddReservation(@RequestBody DataPostAddReservation data)
    {
        reservationService.addReservation(data.getPmrId(), data.getUtilisateurId(), data.getReservation());
        return ResponseEntity.ok(new Response("Reservation Added"));
    }

    @PutMapping(value = "/reservation/updateReservation")
    public ResponseEntity<Response> putUpdateReservation(@RequestBody DataPutUpdateReservation data)
    {
        reservationService.updateReservation(data.getPmrId(), data.getUtilisateurId(), data.getReservation());
        return ResponseEntity.ok(new Response("Reservation Updated"));
    }

    @DeleteMapping(value = "/reservation/deleteReservation")
    public ResponseEntity<Response> deleteReservation(@RequestBody DataDeleteReservation data)
    {
        reservationService.deleteReservation(data.getPmrId(), data.getUtilisateurId());
        return ResponseEntity.ok(new Response("Reservation Deleted"));
    }
}
