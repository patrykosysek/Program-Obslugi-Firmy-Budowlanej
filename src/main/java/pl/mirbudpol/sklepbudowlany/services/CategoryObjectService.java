package pl.mirbudpol.sklepbudowlany.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mirbudpol.sklepbudowlany.entities.CategoryObject;
import pl.mirbudpol.sklepbudowlany.exceptions.ResourceNotFoundException;
import pl.mirbudpol.sklepbudowlany.repositories.CategoryObjectRepository;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CategoryObjectService {

    private final CategoryObjectRepository categoryObjectRepository;

    public List<CategoryObject> findAllByCategory_Id(Long id){
        return categoryObjectRepository.findAllByCategory_Id(id).orElseThrow(()-> new ResourceNotFoundException("Nie znaleziono przedmiotów z takej kategorii"));
    }


}
