package pl.mirbudpol.sklepbudowlany.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.mirbudpol.sklepbudowlany.DTO.CustomUserDetailsDTO;
import pl.mirbudpol.sklepbudowlany.entities.RegisteredUser;
import pl.mirbudpol.sklepbudowlany.exceptions.ResourceNotFoundException;
import pl.mirbudpol.sklepbudowlany.repositories.RegisteredUserRepository;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    RegisteredUserRepository registeredUserRepository;

    public RegisteredUser findByLogin(String login) {
        return registeredUserRepository.findByLogin(login).orElseThrow(() -> new ResourceNotFoundException("Klient o loginie " + login + " nie istnieje"));
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        RegisteredUser user = findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetailsDTO(user);
    }

}
