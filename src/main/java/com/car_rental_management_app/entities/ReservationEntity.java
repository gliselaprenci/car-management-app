package com.car_rental_management_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="reservation")

public class ReservationEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_id")
    Long id;

    @Column(name="reservation_Date")
    private Date reservation_Date;

    @Column(name="start_Date")
    private Date start_Date;

    @Column(name="end_Date")
    private Date end_Date;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private CarEntity carEntity;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")

    private UserEntity userEntity;

    //TODO research how to implement pickup and return branch

}
