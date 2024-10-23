package org.example.tp_rest_pmr.controller.utilisateur_controller_data;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DataPostUpdateUtilisateur
{
    @NonNull
    private String nom;

    @NonNull
    private String prenom;

    @NonNull
    private String email;

    @NonNull
    private String username;
}
