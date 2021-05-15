package pl.mirbudpol.sklepbudowlany.controllers;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.mirbudpol.sklepbudowlany.DTO.*;
import pl.mirbudpol.sklepbudowlany.services.ThingService;

import java.util.List;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping(path = "/api/item")
public class ThingController {

    private final ThingService thingService;

    @ApiOperation("Tworzy dany przedmiot")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addObject(@Validated @RequestBody ThingDTO dto) {
        thingService.createThing(dto);
    }

    @ApiOperation("Modyfikuje dany przedmiot")
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateObject(@PathVariable Long id, @RequestBody ThingDTO dto) {
        thingService.updateThing(id, dto);
    }

    @ApiOperation("Usuwa dany przedmiot")
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteObject(@PathVariable Long id) {
        thingService.deleteThing(id);
    }

    @ApiOperation("Zwraca wszystkie szczegółowe informacje o danym przedmiocie")
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ThingDTOdetails getObject(@PathVariable Long id) {
        return thingService.getThing(id);
    }

    @ApiOperation("Zwraca ilość danego przedmiotu na magazynie")
    @GetMapping(path = "/quantity/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Integer getQuantity(@PathVariable Long id) {
        return thingService.getQuantity(id);
    }

    @ApiOperation("Zwraca przedmioty posiadające w nazwie podany fragment (przykład: cegła zwróci cegła1, cegła2 itd.")
    @GetMapping(path = "/name/{itemName}")
    @ResponseStatus(HttpStatus.OK)
    public List<ThingDTOpage1> getItemsByName(@PathVariable String itemName) {
        return thingService.getItemsByName(itemName);
    }

    @ApiOperation("Zwraca przedmioty posiadające podane w argumencie kategorie (przykład: meble,ogród)")
    @GetMapping(path = "/categories/{categoriesNames}")
    @ResponseStatus(HttpStatus.OK)
    public List<ThingDTOpage1> getItemsByCategories(@PathVariable List<String> categoriesNames) {
        return thingService.getItemsByCategories(categoriesNames);
    }

    @ApiOperation("Zwraca 6 przedmiotów o najlepszych ocenach")
    @GetMapping(path = "/recommended")
    @ResponseStatus(HttpStatus.OK)
    public List<ThingDTOpage1> getRecommendedThings() {
        return thingService.recommendedThings();
    }

    @ApiOperation("Dodaje daną kategorię do przedmiotu")
    @PutMapping(path = "/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void addCategory(@Validated @RequestBody ItemCategoryDTO dto, @PathVariable Long id) {
        thingService.addCategory(dto, id);
    }

    @ApiOperation("Usuwa daną kategorię z przedmiotu")
    @DeleteMapping(path = "/category/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@Validated @RequestBody ItemCategoryDTO dto, @PathVariable Long id) {
        thingService.deleteCategory(dto, id);
    }

    @ApiOperation("Dodaje zdjęcie do danego przedmiotu")
    @PutMapping(path = "/image/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void addImage(@Validated @RequestBody ImageDTO dto, @PathVariable Long id) {
        thingService.addImage(dto, id);
    }

    @ApiOperation("Usuwa zdjęcie z danego przedmiotu")
    @DeleteMapping(path = "/image/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImage(@Validated @RequestBody ImageDTO dto, @PathVariable Long id) {
        thingService.deleteImage(dto, id);

    }

    @ApiOperation("Dodaje materiał elektroniczny do danego przedmiotu")
    @PutMapping(path = "/electronical/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void addElectronical(@Validated @RequestBody ImageDTO dto, @PathVariable Long id) {
        thingService.addElectronicalMaterial(dto, id);
    }

    @ApiOperation("Usuwa materiał elektroniczny z danego przedmiotu")
    @DeleteMapping(path = "/electronical/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteElectronical(@Validated @RequestBody ImageDTO dto, @PathVariable Long id) {
        thingService.deleteElectronicalMaterial(dto, id);
    }
}