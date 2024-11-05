package org.example.tp_rest_pmr.controller.pmr_controller_data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DataDeletePmr
{
    @NonNull
    private String nom;

    @NonNull
    private String description;
}
