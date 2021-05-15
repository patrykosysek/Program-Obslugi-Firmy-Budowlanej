package pl.mirbudpol.sklepbudowlany.services;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mirbudpol.sklepbudowlany.DTO.RatingDTO;
import pl.mirbudpol.sklepbudowlany.DTO.RegisteredClientDTO;
import pl.mirbudpol.sklepbudowlany.entities.Adress;
import pl.mirbudpol.sklepbudowlany.entities.Client;
import pl.mirbudpol.sklepbudowlany.entities.Rating;
import pl.mirbudpol.sklepbudowlany.entities.RegisteredUser;
import pl.mirbudpol.sklepbudowlany.exceptions.ResourceNotFoundException;
import pl.mirbudpol.sklepbudowlany.repositories.ClientRepository;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Klient o id " + id + " nie istnieje"));
    }

    public List<Client> findAllByZarejestrowanyUzytkownikTypUzytkownika(Integer role) {
        return clientRepository.findAllByZarejestrowanyUzytkownikTypUzytkownika(role).orElseThrow(() -> new ResourceNotFoundException("Brak menadżerów"));
    }

    @Transactional
    public Client createRegisteredClient(RegisteredClientDTO dto, Integer role) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(dto.getHaslo());
        dto.setHaslo(encodedPassword);

        Client klient = new Client(dto);


        Adress adres = new Adress(dto);
        adres.setKlient(klient);

        RegisteredUser user = new RegisteredUser(role, dto);

        user.setHaslo(encodedPassword);

        user.setClient(klient);
        klient.setAdres(adres);
        klient.setZarejestrowanyUzytkownik(user);


        return clientRepository.save(klient);

    }

    @Transactional
    public Client createManager(RegisteredClientDTO dto, Long id) {

        Client client = this.findById(id);

        if (client.getZarejestrowanyUzytkownik().getTypUzytkownika() == 1 || client.getZarejestrowanyUzytkownik().getTypUzytkownika() == 2 && client.getZarejestrowanyUzytkownik().getCzyAktywne() == true)
            return this.createRegisteredClient(dto, 2);
        else
            throw (new ResourceNotFoundException("Brak uprawnień"));
    }

    @Transactional
    public Client createAdmin(RegisteredClientDTO dto, Long id) {

        Client client = this.findById(id);

        if (client.getZarejestrowanyUzytkownik().getTypUzytkownika() == 1 && client.getZarejestrowanyUzytkownik().getCzyAktywne() == true)
            return this.createRegisteredClient(dto, 1);
        else
            throw (new ResourceNotFoundException("Brak uprawnień"));
    }

    @Transactional
    public void deleteManager(Long menagoId, Long userId) {

        Client client = this.findById(userId);

        if (client.getZarejestrowanyUzytkownik().getTypUzytkownika() == 1 || client.getZarejestrowanyUzytkownik().getTypUzytkownika() == 2 && client.getZarejestrowanyUzytkownik().getCzyAktywne() == true)
            clientRepository.deleteById(menagoId);
        else
            throw (new ResourceNotFoundException("Brak uprawnień"));
    }

    public List<RegisteredClientDTO> getManagers(Long id) {

        Client client = this.findById(id);
        List<RegisteredClientDTO> registeredClientDTOS = new ArrayList<>();
        if (client.getZarejestrowanyUzytkownik().getTypUzytkownika() == 1 && client.getZarejestrowanyUzytkownik().getCzyAktywne() == true) {

            List<Client> clients = this.findAllByZarejestrowanyUzytkownikTypUzytkownika(2);

            for (Client object : clients) {

                RegisteredClientDTO dto = new RegisteredClientDTO(object);
                registeredClientDTOS.add(dto);
            }
            return registeredClientDTOS;
        } else
            return registeredClientDTOS;
    }

    public List<RatingDTO> getClientRatings(Long id) {

        Client client = this.findById(id);
        List<RatingDTO> ratingsDTO = new ArrayList<>();

        for (Rating rating : client.getOceny()) {
            RatingDTO ratingDTO = new RatingDTO(rating.getId(), rating.getOcena(), rating.getKomentarz(), rating.getThing().getId(), rating.getClient().getId());
            ratingsDTO.add(ratingDTO);
        }

        return ratingsDTO;
    }

}
