package pl.mirbudpol.sklepbudowlany.services;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mirbudpol.sklepbudowlany.DTO.AdressDTO;
import pl.mirbudpol.sklepbudowlany.DTO.ClientDTO;
import pl.mirbudpol.sklepbudowlany.entities.Adress;
import pl.mirbudpol.sklepbudowlany.entities.Client;
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
        adress.setClient(client);
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

}
