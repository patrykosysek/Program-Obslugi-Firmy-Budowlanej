package pl.mirbudpol.sklepbudowlany.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.mirbudpol.sklepbudowlany.DTO.ThingDTO;
import pl.mirbudpol.sklepbudowlany.services.ThingService;

import java.util.List;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping(path = "/przedmiot")
public class ThingController {

    private final ThingService thingService;


    @PostMapping(path = "/dodaj")
    @ResponseStatus(HttpStatus.CREATED)
    public void addClientWithAdress(@Validated @RequestBody ThingDTO dto){
        thingService.creatThing(dto);}


    @GetMapping(path = "/polecane")
    @ResponseStatus(HttpStatus.OK)
    public List<ThingDTO> getRecommendedThings(){
        return thingService.recommendedThings();
    }



}
