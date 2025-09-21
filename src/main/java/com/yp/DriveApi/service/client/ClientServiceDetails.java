package com.yp.DriveApi.service.client;

import com.yp.DriveApi.models.clients.Client;
import com.yp.DriveApi.models.clients.ClientDetails;
import com.yp.DriveApi.repository.ClientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceDetails implements UserDetailsService {

    private ClientRepository clientRepository;

    public ClientServiceDetails(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Client not found with email: " + email));


        return new ClientDetails(client);
    }
}
