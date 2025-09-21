package com.yp.DriveApi.security.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.yp.DriveApi.models.clients.ClientDetails;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenJwt {

    // For simplicity, using hardcoded keys. In production, use secure storage.

    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;


    @PostConstruct
    public void initKeys() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048); // Size of the key
            KeyPair keyPair = keyGen.generateKeyPair();

            this.privateKey = (RSAPrivateKey) keyPair.getPrivate();
            this.publicKey = (RSAPublicKey) keyPair.getPublic();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed in generated key", e);
        }
    }

    public String createTokenJwt(ClientDetails client){
        try {
            var algorithm = Algorithm.RSA256(publicKey, privateKey);

            return JWT.create()
                    .withIssuer("Drive Api")
                    .withSubject(client.getEmail())
                    .withExpiresAt(dateExpiration())
                    .sign(algorithm);

        }catch (Exception e){
            throw new RuntimeException("Failed to create token", e);
        }

    }

    public Object getSubject(String tokenRetrieved) {

        try{
            var algorithm = Algorithm.RSA256(publicKey, privateKey);

            return JWT.require(algorithm)
                    .withIssuer("Drive Api")
                    .build()
                    .verify(tokenRetrieved)
                    .getSubject();
        }catch (JWTVerificationException e){
            throw new RuntimeException("Invalid or expired token" + e);
        }

    }


    private Instant dateExpiration(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
