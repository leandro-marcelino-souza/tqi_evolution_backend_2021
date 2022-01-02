package com.tqi_evolution_avaliacao.config.security;

import com.tqi_evolution_avaliacao.entity.Client;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    static final long EXPIRATIONTIME = 864_000_00;
    static final String SIGNINGKEY = "SecretKey";

    public String gerarToken(Authentication authentication) {
        Client logado = (Client) authentication.getPrincipal();
        return Jwts.builder()
                .setIssuer("API tqi evolution avaliacao")
                .setSubject(logado.getId().toString())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SIGNINGKEY)
                .compact();

    }

        //Validando se o token existe e se é valido
    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(this.SIGNINGKEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Recuperando o Id do Cliente que está setado no token
    public Long getIdClient(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.SIGNINGKEY).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());

    }
}
