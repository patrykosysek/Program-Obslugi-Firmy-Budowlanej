package pl.mirbudpol.sklepbudowlany.controllers;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.mirbudpol.sklepbudowlany.DTO.ImageDTO;
import pl.mirbudpol.sklepbudowlany.DTO.ItemCategoryDTO;
import pl.mirbudpol.sklepbudowlany.DTO.ThingDTO;
import pl.mirbudpol.sklepbudowlany.DTO.ThingDTOpage1;
import pl.mirbudpol.sklepbudowlany.services.ThingService;

import java.util.List;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping(path = "/item")
public class ThingController {

    private final ThingService thingService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addObject(@Validated @RequestBody ThingDTO dto) {
        thingService.createThing(dto);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateObject(@PathVariable Long id, @RequestBody ThingDTO dto) {
        thingService.updateThing(id, dto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteObject(@PathVariable Long id) {
        thingService.deleteThing(id);
    }


    @ApiOperation("Zwraca 6 przedmiotów o najlepszych ocenach")
    @GetMapping(path = "/recommended")
    @ResponseStatus(HttpStatus.OK)
    public List<ThingDTOpage1> getRecommendedThings() {
        return thingService.recommendedThings();
    }

    @PutMapping(path = "/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void addCategory(@Validated @RequestBody ItemCategoryDTO dto, @PathVariable Long id) {
        thingService.addCategory(dto, id);
    }

    @DeleteMapping(path = "/category/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@Validated @RequestBody ItemCategoryDTO dto, @PathVariable Long id) {
        thingService.deleteCategory(dto, id);
    }

    @PutMapping(path = "/image/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void addImage(@Validated @RequestBody ImageDTO dto, @PathVariable Long id) {
        thingService.addImage(dto, id);
    }

    @DeleteMapping(path = "/image/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImage(@Validated @RequestBody ImageDTO dto, @PathVariable Long id) {
        thingService.deleteImage(dto, id);

    }

    @PutMapping(path = "/electronical/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void addElectronical(@Validated @RequestBody ImageDTO dto, @PathVariable Long id) {
        thingService.addElectronicalMaterial(dto, id);
    }

    @DeleteMapping(path = "/electronical/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteElectronical(@Validated @RequestBody ImageDTO dto, @PathVariable Long id) {
        thingService.deleteElectronicalMaterial(dto, id);
    }
}