package com.tqi_evolution_avaliacao.services;



import com.tqi_evolution_avaliacao.dto.CreateClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
    @Autowired
    private ClientService clientService ;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        CreateClientDto currentUser = clientService.findByEmail(email);
        UserDetails user = new org.springframework.security.core
                .userdetails.User(email, currentUser.getSenha(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
        return user;
    }

}}
