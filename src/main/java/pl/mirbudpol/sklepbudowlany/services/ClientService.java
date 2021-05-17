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
import pl.mirbudpol.sklepbudowlany.exceptions.NoPermissions;
import pl.mirbudpol.sklepbudowlany.exceptions.NotValidPhoneNumber;
import pl.mirbudpol.sklepbudowlany.exceptions.ResourceNotFoundException;
import pl.mirbudpol.sklepbudowlany.repositories.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ClientService {

    private final ClientRepository clientRepository;


    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Klient o id " + id + " nie istnieje"));
    }

    public List<Client> findAllByTypUzytkownika(Integer role) {
        return clientRepository.findAllByTypUzytkownika(role).orElseThrow(() -> new ResourceNotFoundException("Brak menadżerów"));
    }

    public void permissions(Client client) {

        if (client.getTypUzytkownika() != 1 || client.getTypUzytkownika() != 2 && client.getCzyAktywne() == false)
            throw new NoPermissions("Brak uprawnień");

    }


    public Boolean validPhoneNumber(String phoneNumber) {

        final String regex = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find();

    }

    @Transactional
    public Client createRegisteredClient(RegisteredClientDTO dto, Integer role) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(dto.getHaslo());
        dto.setHaslo(encodedPassword);

        if (validPhoneNumber(dto.getNrTelefonu())) {
            Client klient = new Client(dto, role);

            klient.setHaslo(encodedPassword);

            Adress adres = new Adress(dto);
            adres.setKlient(klient);

            klient.setAdres(adres);

            return clientRepository.save(klient);
        } else
            throw new NotValidPhoneNumber("Nieprawidłowy numer telefonu");
    }

    @Transactional
    public Client createManager(RegisteredClientDTO dto, Long id) {

        Client client = this.findById(id);

        this.permissions(client);
        return this.createRegisteredClient(dto, 2);

    }

    @Transactional
    public Client createAdmin(RegisteredClientDTO dto, Long id) {

        Client client = this.findById(id);

        if (client.getTypUzytkownika() == 1 && client.getCzyAktywne() == true)
            return this.createRegisteredClient(dto, 1);
        else
            throw (new ResourceNotFoundException("Brak uprawnień"));
    }

    @Transactional
    public void deleteManager(Long menagoId, Long userId) {

        Client client = this.findById(userId);

        permissions(client);
        clientRepository.deleteById(menagoId);

    }

    public List<RegisteredClientDTO> getManagers(Long id) {

        Client client = this.findById(id);
        List<RegisteredClientDTO> registeredClientDTOS = new ArrayList<>();
        this.permissions(client);

        List<Client> clients = this.findAllByTypUzytkownika(2);

        for (Client object : clients) {

            RegisteredClientDTO dto = new RegisteredClientDTO(object);
            registeredClientDTOS.add(dto);
        }
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
