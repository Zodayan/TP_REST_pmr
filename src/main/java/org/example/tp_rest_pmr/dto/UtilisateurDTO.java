package org.example.tp_rest_pmr.dto;

import lombok.*;

import java.util.Set;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@ToString
public class UtilisateurDTO {
    private int id;
    private String nom;
    private String prenom;
    private String password;
    private String mail;
    private String username;

    private Set<ReservationDTO> reservations;
}
