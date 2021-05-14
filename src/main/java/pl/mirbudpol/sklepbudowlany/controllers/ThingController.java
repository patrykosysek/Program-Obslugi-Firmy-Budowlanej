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

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ThingDTOdetails getObject(@PathVariable Long id) {
        return thingService.getThing(id);
    }

    @GetMapping(path = "/quantity/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Integer getQuantity(@PathVariable Long id) {
        return thingService.getQuantity(id);
    }


    @GetMapping(path = "/category")
    @ResponseStatus(HttpStatus.OK)
    public List<ThingDTOpage1> getItemsFromCategory(@RequestBody ItemCategoryDTO dto) {
        return thingService.getItemsFromCategory(dto.getCategoryName());
    }

    @GetMapping(path = "/name")
    @ResponseStatus(HttpStatus.OK)
    public List<ThingDTOpage1> getItemsByName(@RequestBody ItemNameDTO dto) {
        return thingService.getItemsByName(dto.getItemName());
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