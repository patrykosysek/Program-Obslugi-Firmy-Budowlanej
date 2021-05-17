package pl.mirbudpol.sklepbudowlany.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.mirbudpol.sklepbudowlany.DTO.CategoryDTO;
import pl.mirbudpol.sklepbudowlany.DTO.RatingDTO;
import pl.mirbudpol.sklepbudowlany.services.CategoryService;

import java.util.List;


@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping(path = "/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.CREATED)
        public void addCategory(@Validated @RequestBody CategoryDTO dto){
        categoryService.createCategory(dto);}

    @PostMapping(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);}

    @GetMapping(path = "/getAll")
    @ResponseStatus(HttpStatus.CREATED)
    public List<CategoryDTO> getCategories(){
        return categoryService.getCategories();}

    @PostMapping(path = "/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateCategory(@Validated @RequestBody CategoryDTO dto){
        categoryService.updateCategory(dto);}
}
