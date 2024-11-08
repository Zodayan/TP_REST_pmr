package org.example.tp_rest_pmr.controller.reservation_controller_data;

import lombok.*;
import org.example.tp_rest_pmr.entity.EmbeddedIdReservation;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DataPutUpdateReservation
{
    @NonNull
    private Integer pmrId;

    @NonNull
    private Integer utilisateurId;

    @NonNull
    private Integer reservation;
}
