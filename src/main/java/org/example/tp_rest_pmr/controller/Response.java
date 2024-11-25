package org.example.tp_rest_pmr.controller;

import lombok.*;

// Classe servant aux controleurs pour renvoyer une simple réponse sous forme de String.
// Permet à Spring Boot de parser la réponse et de renvoyer un JSON, ce qui évite que le client considère
//que le serveur renvoie une erreur.
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Response {
    private String message;
}
