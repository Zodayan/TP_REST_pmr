package org.example.tp_rest_pmr.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationDTO {

    private UtilisateurDTO utilisateur;
    private PmrDTO pmr;

    /*
    private Integer pmr_id;
    private Integer utilisateur_id;
    */


    // Info de reservation
    private Integer reservation;
}
