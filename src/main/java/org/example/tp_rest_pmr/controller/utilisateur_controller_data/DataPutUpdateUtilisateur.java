package org.example.tp_rest_pmr.controller.utilisateur_controller_data;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DataPutUpdateUtilisateur
{
    @NonNull
    private String nom;

    @NonNull
    private String prenom;

    @NonNull
    private String mail;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String currentPassword;

    @NonNull
    private String currentUsername;


}
