package com.example.demo.controllers.client;

import com.example.demo.dtos.client.ClientDTO;
import com.example.demo.dtos.client.KlientDTO;
import com.example.demo.entities.client.Client;
import com.example.demo.services.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;

@RequiredArgsConstructor
@Validated
@RequestMapping("/clients")
@RestController
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ClientDTO> findAll(@PageableDefault Pageable pageable) {
        return clientService.findAll(pageable);
    }

    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable long id, @RequestBody ClientDTO dto) {
        clientService.update(id, dto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addClient(@RequestBody ClientDTO dto) {
        clientService.create(dto);
    }

    @PostMapping(value = "klient")
    @ResponseStatus(HttpStatus.OK)
    public void addKlient(@Validated @RequestBody KlientDTO dto) {
        clientService.createKlient(dto);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDTO getClient(@PathVariable long id) {
        return clientService.findByIdDTO(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@PathVariable long id) {
        clientService.delete(id);

    }
}