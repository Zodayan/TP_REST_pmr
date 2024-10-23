package org.example.tp_rest_pmr.controller.reservation_controller_data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DataPostDeleteReservation
{
    @NonNull
    private String nomUtilisateur;

    @NonNull
    private String prenomUtilisateur;

    @NonNull
    private String nomPmr;

    @NonNull
    private String descriptionPmr;
}
