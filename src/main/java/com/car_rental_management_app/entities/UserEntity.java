package com.car_rental_management_app.entities;
import com.car_rental_management_app.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="users")

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="lastName")
    private String lastname;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="age")
    private Integer age;
    @Column(name="role")
    private Role role;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userEntity")
    List<ReservationEntity> reservationEntities;

}
