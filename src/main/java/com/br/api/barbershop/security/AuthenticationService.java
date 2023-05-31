package com.br.api.barbershop.security;

import com.br.api.barbershop.service.ClienteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final ClienteServiceImpl clienteService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return clienteService.findEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário inválido!"));
    }
}
