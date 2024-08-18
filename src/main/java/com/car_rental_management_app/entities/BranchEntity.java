package com.car_rental_management_app.entities;

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
@Table(name="branch")

public class BranchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "branch_id")
    Long id;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="revenue")
    private double revenue;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rental_id")

    private RentalEntity rentalEntity;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "branchEntity")
    private List<CarEntity> carEntities;
}
