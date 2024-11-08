package org.example.tp_rest_pmr.controller;

import org.example.tp_rest_pmr.controller.reservation_controller_data.DataGetReservation;
import org.example.tp_rest_pmr.controller.reservation_controller_data.DataPostAddReservation;
import org.example.tp_rest_pmr.controller.reservation_controller_data.DataDeleteReservation;
import org.example.tp_rest_pmr.controller.reservation_controller_data.DataPutUpdateReservation;
import org.example.tp_rest_pmr.entity.ReservationEntity;
import org.example.tp_rest_pmr.repository.ReservationRepository;
import org.example.tp_rest_pmr.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ReservationController
{

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(value = "/reservation", params = "action=getAllReservation")
    public String getAllReservation()
    {
        return reservationService.getAllReservations();
    }

    @GetMapping(value = "/reservation", params = "action=getReservation")
    public String getReservation(DataGetReservation data)
    {
        return reservationService.getReservationById(data.getPmrId(), data.getUtilisateurId());
    }

    @PostMapping(value = "/reservation", params = "action=addReservation")
    public String postAddReservation(@RequestBody DataPostAddReservation data)
    {
        return reservationService.addReservation(data.getPmrId(), data.getUtilisateurId(), data.getNomUtilisateur(), data.getPrenomUtilisateur(), data.getNomPmr(), data.getDescriptionPmr());
    }

    @PutMapping(value = "/reservation", params = "action=updateReservation")
    public String putUpdateReservation(@RequestBody DataPutUpdateReservation data) {
        return reservationService.updateReservation(data.getPmrId(), data.getUtilisateurId(), data.getNomUtilisateur(), data.getPrenomUtilisateur(), data.getNomPmr(), data.getDescriptionPmr(), data.getReservation());
    }

    @DeleteMapping(value = "/reservation", params = "action=deleteReservation")
    public String deleteReservation(@RequestBody DataDeleteReservation data)
    {
        return reservationService.deleteReservation(data.getPmrId(), data.getUtilisateurId());
    }
}
