package pl.mirbudpol.sklepbudowlany.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mirbudpol.sklepbudowlany.DTO.CategoryDTO;
import pl.mirbudpol.sklepbudowlany.DTO.RatingDTO;
import pl.mirbudpol.sklepbudowlany.entities.Category;
import pl.mirbudpol.sklepbudowlany.entities.Client;
import pl.mirbudpol.sklepbudowlany.entities.Rating;
import pl.mirbudpol.sklepbudowlany.entities.Thing;
import pl.mirbudpol.sklepbudowlany.exceptions.ResourceNotFoundException;
import pl.mirbudpol.sklepbudowlany.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public Category createCategory(CategoryDTO dto) {
        final Category category = new Category();
        category.setNazwaKategorii(dto.getNazwaKategorii());
        category.setCategoryObjects(null);

        return categoryRepository.save(category);
    }

    @Transactional
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<CategoryDTO> getCategories(){

        List<CategoryDTO> categoriesDTO = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();

        for(Category category : categories){
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(category.getId());
            categoryDTO.setNazwaKategorii(category.getNazwaKategorii());
            categoriesDTO.add(categoryDTO);
        }
        return categoriesDTO;
    }

    @Transactional
    public void updateCategory(CategoryDTO dto) {
        Optional <Category> category = categoryRepository.findById(dto.getId());
    }


}
