package org.example.tp_rest_pmr.controller.pmr_controller_data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DataPostUpdatePmr
{
    @NonNull
    private String nom;

    @NonNull
    private Integer quantite;

    @NonNull
    private String description;

    @NonNull
    private String pointGeo;
}
