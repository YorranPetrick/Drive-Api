package com.yp.DriveApi.models.clients;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Table(name = "clients")
@Getter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idClient;
    @Column(nullable = true)
    private String name;
    @Column(unique = true, nullable = true)
    private String email;
    @Column(unique = true, nullable = true)
    private String cpf;
    @Column(nullable = true)
    private String password;
}
