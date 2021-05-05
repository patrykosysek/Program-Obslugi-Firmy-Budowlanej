package pl.mirbudpol.sklepbudowlany.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.mirbudpol.sklepbudowlany.DTO.ClientDTO;
import pl.mirbudpol.sklepbudowlany.DTO.RegisteredUserDTO;
import pl.mirbudpol.sklepbudowlany.services.RegisteredUserService;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping(path = "/registeredusers")
public class RegisteredUserController {

    private final RegisteredUserService registeredUserService;

    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRegisteredUser(@Validated @RequestBody RegisteredUserDTO dto){
        registeredUserService.createRegisteredUser(dto);}
}
