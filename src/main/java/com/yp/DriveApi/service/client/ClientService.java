package com.yp.DriveApi.service.client;

import com.yp.DriveApi.models.clients.Client;
import com.yp.DriveApi.models.clients.ClientRequestDto;
import com.yp.DriveApi.models.exceptions.ResponseExceptions;
import com.yp.DriveApi.repository.ClientRepository;
import com.yp.DriveApi.security.spring.SpringSecurityConfig;
import org.springframework.stereotype.Service;

@Service
public class ClientService{

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseExceptions registrationClient(ClientRequestDto client) {
        try {

            var password = SpringSecurityConfig.passwordEncoder().encode(client.password());
            Client clientCreate = new Client(client.name(), client.email(), client.cpf(), password);

            clientRepository.save(clientCreate);
            return new ResponseExceptions("Client registered successfully", true);

        }catch (RuntimeException e){
            return new ResponseExceptions("Falied to register client: " + e, false);
        }
    }

}
