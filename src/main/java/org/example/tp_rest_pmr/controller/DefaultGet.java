package org.example.tp_rest_pmr.controller;

import org.example.tp_rest_pmr.controller.reservation_controller_data.DataDeleteReservation;
import org.example.tp_rest_pmr.controller.reservation_controller_data.DataGetReservation;
import org.example.tp_rest_pmr.controller.reservation_controller_data.DataPostAddReservation;
import org.example.tp_rest_pmr.controller.reservation_controller_data.DataPutUpdateReservation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Ce controller sert de controleur pour le GET par défaut (en cas de requete non valide)
 */
@RestController
public class DefaultGet {

    @GetMapping
    public String get()
    {
        return "Get\nErreur, vous ne devriez pas arriver ici ! (oui c'est une erreur 404)";
    }

    @RestController
    public static class ReservationController
    {
        @GetMapping(value = "/reservation", params = "action=getAllReservation")
        public String getAllReservation()
        {
            return "getAllReservation";
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

        @PostMapping(value = "/reservation", params = "action=updateReservation")
        public String postUpdateReservation(@RequestBody DataPutUpdateReservation data)
        {
            return "postUpdateReservation " + data;
        }

        @PostMapping(value = "/reservation", params = "action=deleteReservation")
        public String postDeleteReservation(@RequestBody DataDeleteReservation data)
        {
            return "postDeleteReservation" + data;
        }
    }
}
