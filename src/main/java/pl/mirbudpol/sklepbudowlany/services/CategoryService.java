package pl.mirbudpol.sklepbudowlany.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mirbudpol.sklepbudowlany.DTO.CategoryDTO;
import pl.mirbudpol.sklepbudowlany.entities.Category;
import pl.mirbudpol.sklepbudowlany.repositories.CategoryRepository;

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




}
