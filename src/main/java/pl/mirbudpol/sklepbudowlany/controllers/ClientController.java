package pl.mirbudpol.sklepbudowlany.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.mirbudpol.sklepbudowlany.DTO.ClientDTO;
import pl.mirbudpol.sklepbudowlany.services.ClientService;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping(path = "/clients")
public class ClientController {

private final ClientService clientService;

@PostMapping(path = "/addWithAdress")
@ResponseStatus(HttpStatus.CREATED)
public void addClientWithAdress(@Validated @RequestBody ClientDTO dto){clientService.createClientWithAdress(dto);}

    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addClient(@Validated @RequestBody ClientDTO dto){clientService.createClient(dto);}

}
