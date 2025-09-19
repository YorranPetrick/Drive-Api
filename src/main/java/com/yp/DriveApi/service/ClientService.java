package com.yp.DriveApi.service;

import com.yp.DriveApi.models.clients.Client;
import com.yp.DriveApi.models.exceptions.ResponseExceptions;
import com.yp.DriveApi.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService{

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseExceptions registrationClient(Client client) {
        try {
            clientRepository.save(client);
            return new ResponseExceptions("Client registered successfully", true);
        }catch (RuntimeException e){
            return new ResponseExceptions("Falied to register client: " + e, false);
        }
    }

}
