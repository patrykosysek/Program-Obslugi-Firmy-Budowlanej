package pl.mirbudpol.sklepbudowlany.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mirbudpol.sklepbudowlany.DTO.ClientDTO;
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

    @Transactional
    public Client createClientWithAdress(ClientDTO dto) {
        final Client client = new Client();
        client.setImie(dto.getImie());
        client.setNazwisko(dto.getNazwisko());
        client.setEmail(dto.getEmail());

        final Adress adress = new Adress();
        adress.setKlient(client);
        adress.setKraj(dto.getAdres().getKraj());
        adress.setMiejscowosc(dto.getAdres().getMiejscowosc());
        adress.setKodPocztowy(dto.getAdres().getKodPocztowy());
        adress.setUlicaNrDomu(dto.getAdres().getUlicaNrDomu());

        client.setAdres(adress);


        return clientRepository.save(client);
    }

    @Transactional
    public Client createClient(ClientDTO dto) {
        final Client client = new Client();
        client.setImie(dto.getImie());
        client.setNazwisko(dto.getNazwisko());
        client.setEmail(dto.getEmail());
        client.setAdres(null);

        return clientRepository.save(client);
    }

    @Transactional
    public Client creatRegisteredClient(RegisteredClientDTO dto) {

        Client klient = new Client();
        klient.setImie(dto.getImie());
        klient.setEmail(dto.getEmail());
        klient.setNazwisko(dto.getNazwisko());

        Adress adres = new Adress();
        adres.setMiejscowosc(dto.getMiejscowosc());
        adres.setKraj(dto.getKraj());
        adres.setKodPocztowy(dto.getKodPocztowy());
        adres.setUlicaNrDomu(dto.getUlicaNrDomu());
        adres.setKlient(klient);


        RegisteredUser user = new RegisteredUser();
        user.setHaslo(dto.getHaslo());
        user.setCzyAktywne(true);
        user.setTypUzytkownika(3);
        user.setLogin(dto.getLogin());
        user.setClient(klient);

        klient.setAdres(adres);
        klient.setZarejestrowanyUzytkownik(user);


        return clientRepository.save(klient);

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
