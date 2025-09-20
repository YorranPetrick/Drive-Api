package com.yp.DriveApi.controller.client;

import com.yp.DriveApi.models.clients.Client;
import com.yp.DriveApi.models.clients.ClientLoginDto;
import com.yp.DriveApi.security.token.TokenJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class ClientLoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenJwt tokenJwt;

    public ResponseEntity loginClient(ClientLoginDto clientLoginDto) {
        var token = new UsernamePasswordAuthenticationToken(clientLoginDto.email(), clientLoginDto.password());
        var authentication = authenticationManager.authenticate(token);

        var tokenGenerated = tokenJwt.createTokenJwt((Client) authentication.getPrincipal());
        return ResponseEntity.ok(tokenGenerated);
    }
}
