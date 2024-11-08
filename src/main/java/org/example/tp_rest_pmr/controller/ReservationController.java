package org.example.tp_rest_pmr.controller;

import org.example.tp_rest_pmr.controller.reservation_controller_data.DataGetReservation;
import org.example.tp_rest_pmr.controller.reservation_controller_data.DataPostAddReservation;
import org.example.tp_rest_pmr.controller.reservation_controller_data.DataDeleteReservation;
import org.example.tp_rest_pmr.controller.reservation_controller_data.DataPutUpdateReservation;
import org.example.tp_rest_pmr.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController
{

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(value = "/reservation", params = "action=getAllReservations")
    public String getAllReservations()
    {
        return reservationService.getAllReservations().toString();
    }

    @GetMapping(value = "/reservation", params = "action=getReservation")
    public String getReservation(DataGetReservation data)
    {
        reservationService.getReservationById(data.getPmrId(), data.getUtilisateurId());
        return "getReservation " + data;
    }

    @PostMapping(value = "/reservation", params = "action=addReservation")
    public void postAddReservation(@RequestBody DataPostAddReservation data)
    {
        reservationService.addReservation(data.getPmrId(), data.getUtilisateurId(), data.getReservation());
    }

    @PutMapping(value = "/reservation", params = "action=updateReservation")
    public void putUpdateReservation(@RequestBody DataPutUpdateReservation data)
    {
        reservationService.updateReservation(data.getPmrId(), data.getUtilisateurId(), data.getReservation());
    }

    @DeleteMapping(value = "/reservation", params = "action=deleteReservation")
    public void deleteReservation(@RequestBody DataDeleteReservation data)
    {
        reservationService.deleteReservation(data.getPmrId(), data.getUtilisateurId());
    }
}
