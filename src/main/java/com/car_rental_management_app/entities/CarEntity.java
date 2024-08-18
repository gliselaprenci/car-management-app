package com.car_rental_management_app.entities;

import com.car_rental_management_app.enums.Color;
import com.car_rental_management_app.enums.Engine;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "color")
    private Color color;

    @Column(name = "model")
    private String model;

    @Column(name = "productionYear")
    private String productionYear;

    @Column(name = "licensePlate")
    private String licensePlate;

    @Column(name = "rentalPerDay")
    private String rentalPerDay;

    @Column(name = "engine")
    private Engine engine;

    @Column(name = "isAvailable")
    private Boolean isAvailable;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "branch_id")
    private  BranchEntity branchEntity;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "carEntity")
    private List<ReservationEntity> reservationEntities;
}
