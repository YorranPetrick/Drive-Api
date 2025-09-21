package com.yp.DriveApi.models.clients;

import com.yp.DriveApi.models.rent.VehicleRental;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idClient;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "clientRental")
    private List<VehicleRental> rentals;

}
