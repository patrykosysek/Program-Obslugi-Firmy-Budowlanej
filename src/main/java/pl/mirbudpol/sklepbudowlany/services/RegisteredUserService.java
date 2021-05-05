package pl.mirbudpol.sklepbudowlany.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mirbudpol.sklepbudowlany.DTO.ClientDTO;
import pl.mirbudpol.sklepbudowlany.DTO.RegisteredUserDTO;
import pl.mirbudpol.sklepbudowlany.entities.RegisteredUser;
import pl.mirbudpol.sklepbudowlany.repositories.RegisteredUserRepository;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class RegisteredUserService {

    private final RegisteredUserRepository registeredUserRepository;

    @Transactional
    public RegisteredUser createRegisteredUser(RegisteredUserDTO dto) {
        final RegisteredUser registeredUser = new RegisteredUser();
        registeredUser.setLogin(dto.getLogin());
        registeredUser.setHaslo(dto.getHaslo());
        registeredUser.setTypUzytkownika(dto.getTypUzytkownika());
        registeredUser.setCzyAktywne(dto.isCzyAktywne());

        return registeredUserRepository.save(registeredUser);
    }
}
