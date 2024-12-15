package org.example.tp_rest_pmr.dto;

import lombok.*;
import org.example.tp_rest_pmr.entity.EmbeddedIdReservation;
import org.example.tp_rest_pmr.entity.ReservationEntity;

import java.util.Set;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@ToString
public class PmrDTO {
    private int id;
    private String nom;
    private int quantite;
    private String description;
    private String point_geo;

    private Set<EmbeddedIdReservation> reservationsId;
}
