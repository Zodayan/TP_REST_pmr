package org.example.tp_rest_pmr.controller.utilisateur_controller_data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DataGetUserByUsername {
    @NonNull
    private String username;
}