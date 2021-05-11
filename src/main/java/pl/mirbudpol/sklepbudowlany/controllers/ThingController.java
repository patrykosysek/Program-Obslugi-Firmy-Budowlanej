package pl.mirbudpol.sklepbudowlany.controllers;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.mirbudpol.sklepbudowlany.DTO.ItemCategoryDTO;
import pl.mirbudpol.sklepbudowlany.DTO.ThingDTO;
import pl.mirbudpol.sklepbudowlany.DTO.ThingDTOpage1;
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
    public void addObject(@Validated @RequestBody ThingDTO dto) {
        thingService.creatThing(dto);
    }

    @PostMapping(path = "/dodajzImg")
    @ResponseStatus(HttpStatus.CREATED)
    public void addObjectWithImages(@Validated @RequestBody ThingDTO dto) {
        thingService.creatThingWithImg(dto);
    }

    @PostMapping(path = "/dodajzImgMaterialyElektroniczne")
    @ResponseStatus(HttpStatus.CREATED)
    public void addObjectWithImagesAndElectronicMaterials(@Validated @RequestBody ThingDTO dto) {
        thingService.creatThingWithImgAndElectronicMaterials(dto);
    }

    @ApiOperation("Zwraca 6 przedmiotów o najlepszych ocenach")
    @GetMapping(path = "/polecane")
    @ResponseStatus(HttpStatus.OK)
    public List<ThingDTOpage1> getRecommendedThings() {
        return thingService.recommendedThings();
    }

    @PutMapping(path = "/dodaj/kategorie")
    @ResponseStatus(HttpStatus.OK)
    public void addCategory(@Validated @RequestBody ItemCategoryDTO dto){
        thingService.addCategory(dto);
    }
}
