package org.example.tp_rest_pmr;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
public class ReservationId implements Serializable {

    private PmrEntity pmrId;

    private UtilisateurEntity utilisateurId;
}
