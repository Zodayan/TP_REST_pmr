package org.example.tp_rest_pmr.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class ReservationDTO {
    private int utilisateurId;
    private int pmrId;

    // Info de reservation
    private Integer reservation;
}
