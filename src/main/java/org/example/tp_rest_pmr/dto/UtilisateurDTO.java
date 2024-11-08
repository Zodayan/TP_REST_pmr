package org.example.tp_rest_pmr.dto;

import lombok.*;

import java.util.Set;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class UtilisateurDTO {
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String username;

    private Set<Integer> pmrIds;
}
