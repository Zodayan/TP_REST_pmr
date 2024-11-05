package org.example.tp_rest_pmr.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class UtilisateurDTO {
    private String nom;
    private String prenom;
    private String email;
    private String username;

}
