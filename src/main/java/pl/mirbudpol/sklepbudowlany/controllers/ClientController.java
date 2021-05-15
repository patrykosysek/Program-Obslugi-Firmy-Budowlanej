package pl.mirbudpol.sklepbudowlany.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.mirbudpol.sklepbudowlany.DTO.RatingDTO;
import pl.mirbudpol.sklepbudowlany.DTO.RegisteredClientDTO;
import pl.mirbudpol.sklepbudowlany.services.ClientService;

import java.util.List;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping(path = "/api/clients")
public class ClientController {

    private final ClientService clientService;

    @ApiOperation("Endpoint do zarejestrowania zwykłego użytkownika")
    @PostMapping(path = "/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerClient(@Validated @RequestBody RegisteredClientDTO dto) {
        clientService.createRegisteredClient(dto, 3);
    }

    @ApiOperation("Endpoint do zarejestrowania menadżera, dodatkowo trzeba przekazać id użytkownika, który próbuje go zarejestrować")
    @PostMapping(path = "/registration/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerManager(@Validated @RequestBody RegisteredClientDTO dto, @PathVariable Long id) {
        clientService.createManager(dto, id);
    }

    @ApiOperation("Endpoint do zarejestrowania admina, dodatkowo trzeba przekazać id użytkownika, który próbuje go zarejestrować")
    @PostMapping(path = "/registration/admin/{id}}")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAdmin(@Validated @RequestBody RegisteredClientDTO dto, @PathVariable Long id) {
        clientService.createAdmin(dto, id);
    }

    @ApiOperation("Zwraca wszystkie oceny wystawione przez danego użytkownika")
    @GetMapping(path = "/ratings/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<RatingDTO> getClientRatings(@PathVariable Long id) {
        return clientService.getClientRatings(id);
    }

    @ApiOperation("Zwraca liste menadżerów, dodatkowo trzeba przekazać id użytkownika, który próbuje pobrać listę")
    @GetMapping(path = "/managers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<RegisteredClientDTO> getManagers(@PathVariable Long id) {
        return clientService.getManagers(id);
    }

    @ApiOperation("Usuwa menadżera o podanym id, dodatkowo trzeba przekazać id użytkownika, który próbuje go usunąć")
    @DeleteMapping(path = "/managers/{menagoId}/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteManager(@PathVariable Long menagoId, @PathVariable Long userId) {
        clientService.deleteManager(menagoId, userId);
    }
}
