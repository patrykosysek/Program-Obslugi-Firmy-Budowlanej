package pl.mirbudpol.sklepbudowlany.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mirbudpol.sklepbudowlany.DTO.ClientDTO;
import pl.mirbudpol.sklepbudowlany.DTO.RegisteredClientDTO;
import pl.mirbudpol.sklepbudowlany.entities.Adress;
import pl.mirbudpol.sklepbudowlany.entities.Client;
import pl.mirbudpol.sklepbudowlany.entities.RegisteredUser;
import pl.mirbudpol.sklepbudowlany.repositories.ClientRepository;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ClientService {

    private final ClientRepository clientRepository;


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

    @Transactional public Client creatRegisteredClient(RegisteredClientDTO dto){

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


}
