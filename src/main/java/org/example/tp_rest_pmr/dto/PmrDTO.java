package org.example.tp_rest_pmr.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class PmrDTO {
    private String nom;
    private int quantite;
    private String description;
    private String point_geo;

}
