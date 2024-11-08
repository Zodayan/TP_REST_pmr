package org.example.tp_rest_pmr.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "pmr")
public class PmrEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "quantite", nullable = false)
    private Integer quantite;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "point_geo", nullable = false, length = 100)
    private String point_geo;

    @OneToMany(mappedBy = "pmr")
    private Set<ReservationEntity> reservations;



}
