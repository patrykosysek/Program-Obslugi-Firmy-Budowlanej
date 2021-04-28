package com.example.demo.services.client;

import com.example.demo.dtos.client.ClientDTO;
import com.example.demo.dtos.client.KlientDTO;
import com.example.demo.entities.client.Client;
import com.example.demo.entities.klient.Klient;
import com.example.demo.entities.project.Project;
import com.example.demo.repositories.client.ClientRepository;
import com.example.demo.repositories.klient.KlientRepository;
import com.example.demo.services.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ProjectService projectService;
    private final KlientRepository klientRepository;

    public Page<ClientDTO> findAll(Pageable pageable) {
        final Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(client -> new ClientDTO(
                client.getId(),
                client.getName(),
                Optional.ofNullable(client.getProject())
                        .map(Project::getId)
                        .orElse(null)
        ));
    }

    public Client findById(long id) {
        return clientRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public ClientDTO findByIdDTO(long id)
    {
        Client client = findById(id);
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        if(client.getProject()==null)
            clientDTO.setProjectId(null);
        else
            clientDTO.setProjectId(client.getProject().getId());
        return clientDTO;
    }


    @Transactional
    public Client create(ClientDTO dto) {
        final Client client = new Client();
        final Project project = projectService.findById(dto.getProjectId());
        client.setName(dto.getName());
        client.setProject(project);
        return clientRepository.save(client);
    }

    @Transactional
    public Klient createKlient(KlientDTO dto) {
        final Klient klient = new Klient();

      klient.setImie(dto.getImie());
        klient.setNazwisko(dto.getNazwisko());
        klient.setEmail(dto.getEmail());
        return klientRepository.save(klient);
    }


    @Transactional
    public Client update(long id, ClientDTO dto) {
        final Client client = findById(id);
        final Project project = projectService.findById(dto.getProjectId());
        client.setName(dto.getName());
        client.setProject(project);
        return clientRepository.save(client);
    }

    @Transactional
    public void delete(long id)
    {
        final Client client = findById(id);
        clientRepository.delete(client);
    }
    public long count() {
        return clientRepository.count();
    }

}
