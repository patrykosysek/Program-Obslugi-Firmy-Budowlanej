package pl.mirbudpol.sklepbudowlany.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.mirbudpol.sklepbudowlany.DTO.CategoryDTO;
import pl.mirbudpol.sklepbudowlany.services.CategoryService;


@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRegisteredUser(@Validated @RequestBody CategoryDTO dto){
        categoryService.createCategory(dto);}
}
