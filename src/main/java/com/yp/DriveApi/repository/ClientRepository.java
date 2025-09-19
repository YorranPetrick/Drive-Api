package com.yp.DriveApi.repository;

import com.yp.DriveApi.models.clients.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

}
