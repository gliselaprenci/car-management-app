package com.car_rental_management_app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rental")

public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rental_id")
     Long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="owner")
    private String owner;

    //create the relationship mapping between rental and branch entitiies

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "rentalEntity")
    private List<BranchEntity> branchEntities;
}
