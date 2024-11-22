package org.example.tp_rest_pmr.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationDTO {
    private UtilisateurDTO utilisateur;
    private PmrDTO pmr;

    // Info de reservation
    private Integer reservation;
}
