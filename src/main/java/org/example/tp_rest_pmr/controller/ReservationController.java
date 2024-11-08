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
        return "getAllReservations";
    }

    @GetMapping(value = "/reservation", params = "action=getReservation")
    public String getReservation(DataGetReservation data)
    {
        return "getReservation " + data;
    }

    @PostMapping(value = "/reservation", params = "action=addReservation")
    public String postAddReservation(@RequestBody DataPostAddReservation data)
    {
        return "postAddReservation " + data;
    }

    @PutMapping(value = "/reservation", params = "action=updateReservation")
    public String putUpdateReservation(@RequestBody DataPutUpdateReservation data)
    {
        return "putUpdateReservation " + data;
    }

    @DeleteMapping(value = "/reservation", params = "action=deleteReservation")
    public String deleteReservation(@RequestBody DataDeleteReservation data)
    {
        return "deleteReservation" + data;
    }
}
