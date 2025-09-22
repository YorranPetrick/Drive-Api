package com.yp.DriveApi.controller.client;

import com.yp.DriveApi.models.clients.ClientRequestDto;
import com.yp.DriveApi.models.exceptions.ResponseExceptions;
import com.yp.DriveApi.service.client.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @PostMapping
    public ResponseEntity createClient(@RequestBody @Valid ClientRequestDto client) {
        ResponseExceptions response = clientService.registrationClient(client);
        if (response.getSuccessful()){
            return ResponseEntity.ok(response.getMessage());
        }
        return ResponseEntity.badRequest().body(response.getMessage());
    }
}
