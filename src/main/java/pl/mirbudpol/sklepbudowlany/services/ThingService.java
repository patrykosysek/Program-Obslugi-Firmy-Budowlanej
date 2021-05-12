package pl.mirbudpol.sklepbudowlany.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mirbudpol.sklepbudowlany.DTO.ImageDTO;
import pl.mirbudpol.sklepbudowlany.DTO.ItemCategoryDTO;
import pl.mirbudpol.sklepbudowlany.DTO.ThingDTO;
import pl.mirbudpol.sklepbudowlany.DTO.ThingDTOpage1;
import pl.mirbudpol.sklepbudowlany.entities.*;
import pl.mirbudpol.sklepbudowlany.exceptions.ResourceNotFoundException;
import pl.mirbudpol.sklepbudowlany.repositories.*;

import java.util.*;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ThingService {

    private final ThingRepository thingRepository;
    private final CategoryRepository categoryRepository;
    private final RatingRepository ratingRepository;
    private final CategoryService categoryService;
    private final CategoryObjectRepository categoryObjectRepository;
    private final ImagesRepository imagesRepository;
    private final ElectronicalMaterialRepository electronicalMaterialRepository;

    public Thing findById(Long id) {
        return thingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Przedmiot o " + id + " nie istnieje"));
    }


    @Transactional
    public Thing createThing(ThingDTO dto) {
        final Thing thing = new Thing(dto);

        List<Category> kategorie = new ArrayList<>();

        for (String nazwa : dto.getKategoriaId()) {
            Category kategoria = categoryService.findByNazwaKategorii(nazwa);
            kategorie.add(kategoria);
        }

        List<CategoryObject> przedmiotyKategorie = new ArrayList<>();

        for (Category kategoria : kategorie) {
            CategoryObject objektKategorii = new CategoryObject();
            objektKategorii.setThing(thing);
            objektKategorii.setCategory(kategoria);
            przedmiotyKategorie.add(objektKategorii);
        }

        List<Images> zdjecia = new ArrayList<>();
        for (String ref : dto.getZdjecia()) {
            Images zdjecie = new Images();
            zdjecie.setRef(ref);
            zdjecie.setThing(thing);
            zdjecia.add(zdjecie);
        }

        List<ElectronicMaterial> materalyElektroniczne = new ArrayList<>();
        for (String ref : dto.getMaterialyElektroniczne()) {
            ElectronicMaterial electronicMaterial = new ElectronicMaterial();
            electronicMaterial.setRef(ref);
            electronicMaterial.setThing(thing);
            materalyElektroniczne.add(electronicMaterial);
        }


        thing.setCategoryObjects(przedmiotyKategorie);
        thing.setZdjecia(zdjecia);
        thing.setMaterialyElektoniczne(materalyElektroniczne);
        return thingRepository.save(thing);
    }

    @Transactional
    public void updateThing(Long id, ThingDTO dto) {

        Thing thing = this.findById(id);
        thing.update(dto);
    }

    @Transactional
    public void deleteThing(Long id) {
        thingRepository.deleteById(id);
    }

    public ThingDTO getThing(Long id) {
        ThingDTO dto = new ThingDTO(this.findById(id));
        return dto;
    }

    public List<ThingDTOpage1> recommendedThings() {

        Map<Long, Float> srednia = new HashMap<>();

        List<Thing> rekomednowane = thingRepository.findAll();
        List<ThingDTOpage1> rekomendowane_zwrot = new ArrayList<>();

        for (Thing thing : rekomednowane) {
            Float avg = 0f;
            int i = 0;
            List<Rating> oceny = ratingRepository.findAllByThingId(thing.getId());
            for (Rating rating : oceny) {
                avg += rating.getOcena();
                i++;
            }
            srednia.put(thing.getId(), avg / i);
        }

        LinkedHashMap<Long, Float> sorted_srednia = new LinkedHashMap<>();

        srednia.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> sorted_srednia.put(x.getKey(), x.getValue()));


        int liczba_zwracanych_przedmiotow = srednia.size() > 6 ? 6 : srednia.size();
        int j = 0;

        for (Map.Entry<Long, Float> entry : sorted_srednia.entrySet()) {
            if (j == liczba_zwracanych_przedmiotow)
                break;
            else {
                Thing przedmiot = this.findById(entry.getKey());
                if (przedmiot.getRatings().size() == 0)
                    j--;
                else {
                    Float sr = entry.getValue();
                    ThingDTOpage1 przedmiot_rekomendowany = new ThingDTOpage1(przedmiot, sr);
                    rekomendowane_zwrot.add(przedmiot_rekomendowany);
                }
            }
            j++;
        }


        return rekomendowane_zwrot;
    }

    @Transactional
    public void addCategory(ItemCategoryDTO dto, Long id) {

        Thing thing = this.findById(id);
        Category category = categoryService.findByNazwaKategorii(dto.getCategoryName());

        CategoryObject categoryObject = new CategoryObject(category, thing);
        thing.getCategoryObjects().add(categoryObject);

        thingRepository.save(thing);
    }

    @Transactional
    public void deleteCategory(ItemCategoryDTO dto, Long id) {

        CategoryObject categoryObject = categoryObjectRepository.findByThing_IdAndCategory_Id(id, categoryService.findByNazwaKategorii(
                dto.getCategoryName()).getId()).orElseThrow(() -> new ResourceNotFoundException("Nieznaleziono takiego przedmiotu lub kategorii"));

        categoryObjectRepository.deleteById(categoryObject.getId());
    }

    @Transactional
    public void addImage(ImageDTO dto, Long id) {

        Thing thing = this.findById(id);

        Images image = new Images(dto.getRef(), thing);
        thing.getZdjecia().add(image);

        thingRepository.save(thing);
    }

    @Transactional
    public void deleteImage(ImageDTO dto, Long id) {

        Images image = imagesRepository.findByRefAndThingId(dto.getRef(), id).orElseThrow(() -> new ResourceNotFoundException("Nie znaleziono takiego przedmiotu lub zdjęcia"));
        imagesRepository.deleteById(image.getId());
    }

    @Transactional
    public void addElectronicalMaterial(ImageDTO dto, Long id) {

        Thing thing = this.findById(id);

        ElectronicMaterial electronicMaterial = new ElectronicMaterial(dto.getRef(), thing);
        thing.getMaterialyElektoniczne().add(electronicMaterial);

        thingRepository.save(thing);
    }

    @Transactional
    public void deleteElectronicalMaterial(ImageDTO dto, Long id) {

        ElectronicMaterial electronicMaterial = electronicalMaterialRepository.findByRefAndThingId(dto.getRef(), id).orElseThrow(() -> new ResourceNotFoundException("Nie znaleziono takiego przedmiotu lub materiału elektronicznego"));
        electronicalMaterialRepository.deleteById(electronicMaterial.getId());
    }

}

