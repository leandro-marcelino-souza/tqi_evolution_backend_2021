package com.tqi_evolution_avaliacao.config.security;

import com.tqi_evolution_avaliacao.entity.Client;
import com.tqi_evolution_avaliacao.repositories.ClientRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private ClientRepository clientRepository;

    public AuthenticationTokenFilter(TokenService tokenService, ClientRepository clientRepository) {
        this.tokenService = tokenService;
        this.clientRepository = clientRepository;
    }



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = recuperarToken(request);
       boolean valido = tokenService.isTokenValido(token);
       if(valido){
           autenticarCliente(token);

       }
        filterChain.doFilter(request, response);
    }
    //forcando a autenticação
    private void autenticarCliente(String token) {
        Long idClient = tokenService.getIdClient(token);
        Client client = clientRepository.findById(idClient).get();

     UsernamePasswordAuthenticationToken authentication = new  UsernamePasswordAuthenticationToken(client, null, client.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
        //Bearer + espaco, igual a 7 posições
        return token.substring(7, token.length());
    }
}
