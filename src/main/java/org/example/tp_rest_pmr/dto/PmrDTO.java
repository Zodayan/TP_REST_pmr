package org.example.tp_rest_pmr.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class PmrDTO {
    private String name;
    private int quantity;
    private String description;
    private String point_geo;

}
