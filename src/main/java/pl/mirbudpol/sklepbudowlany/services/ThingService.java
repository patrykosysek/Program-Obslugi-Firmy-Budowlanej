package pl.mirbudpol.sklepbudowlany.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mirbudpol.sklepbudowlany.DTO.ThingDTO;
import pl.mirbudpol.sklepbudowlany.DTO.ThingDTOpage1;
import pl.mirbudpol.sklepbudowlany.entities.*;
import pl.mirbudpol.sklepbudowlany.repositories.CategoryRepository;
import pl.mirbudpol.sklepbudowlany.repositories.RatingRepository;
import pl.mirbudpol.sklepbudowlany.repositories.ThingRepository;

import java.util.*;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ThingService {

    private final ThingRepository thingRepository;
    private final CategoryRepository categoryRepository;
    private final RatingRepository ratingRepository;

    @Transactional
    public Thing creatThing(ThingDTO dto)
    {
        final Thing thing = new Thing();
        thing.setNazwa(dto.getNazwa());
        thing.setOpis(dto.getOpis());
        thing.setCenaZakupu(dto.getCenaZakupu());
        thing.setIloscNaMagazynie(dto.getIloscNaMagazynie());
        thing.setCenaSprzedazy(dto.getCenaSprzedazy());
        thing.setCzyArchiwalny(dto.getCzyArchiwalny());

        List<Category> kategorie = new ArrayList<>();

        for(String nazwa : dto.getKategoriaId())
        {
            Category kategoria = categoryRepository.findByNazwaKategorii(nazwa);
            if(kategoria!=null)
                kategorie.add(kategoria);
        }

        List<CategoryObject> przedmiotyKategorie = new ArrayList<>();

        for(Category kategoria: kategorie)
        {
            CategoryObject objektKategorii = new CategoryObject();
            objektKategorii.setThing(thing);
            objektKategorii.setCategory(kategoria);
            przedmiotyKategorie.add(objektKategorii);
        }

        thing.setCategoryObjects(przedmiotyKategorie);

        return thingRepository.save(thing);

    }

    @Transactional
    public Thing creatThingWithImg(ThingDTO dto)
    {
        final Thing thing = new Thing();
        thing.setNazwa(dto.getNazwa());
        thing.setOpis(dto.getOpis());
        thing.setCenaZakupu(dto.getCenaZakupu());
        thing.setIloscNaMagazynie(dto.getIloscNaMagazynie());
        thing.setCenaSprzedazy(dto.getCenaSprzedazy());
        thing.setCzyArchiwalny(dto.getCzyArchiwalny());


        List<Images> zdjecia = new ArrayList<>();
        for (String ref: dto.getZdjecia())
        {
            Images zdjecie = new Images();
            zdjecie.setRef(ref);
            zdjecie.setThing(thing);
            zdjecia.add(zdjecie);
        }

        List<Category> kategorie = new ArrayList<>();

        for(String nazwa : dto.getKategoriaId())
        {
            Category kategoria = categoryRepository.findByNazwaKategorii(nazwa);
            if(kategoria!=null)
                kategorie.add(kategoria);
        }

        List<CategoryObject> przedmiotyKategorie = new ArrayList<>();

        for(Category kategoria: kategorie)
        {
            CategoryObject objektKategorii = new CategoryObject();
            objektKategorii.setThing(thing);
            objektKategorii.setCategory(kategoria);
            przedmiotyKategorie.add(objektKategorii);
        }

        thing.setCategoryObjects(przedmiotyKategorie);
        thing.setZdjecia(zdjecia);

        return thingRepository.save(thing);
    }

    public List<ThingDTOpage1> recommendedThings() {

    Map<Long,Float> srednia = new HashMap<>();

        List<Thing> rekomednowane = thingRepository.findAll();
        List<ThingDTOpage1> rekomendowane_zwrot = new ArrayList<>();

      for(Thing thing : rekomednowane)
      {
          Float avg = 0f;
          int i = 0;
          List<Rating> oceny = ratingRepository.findAllByThingId(thing.getId());
          for(Rating rating: oceny)
          {
              avg += rating.getOcena();
              i++;
          }
          srednia.put(thing.getId(),avg/i);
      }

      LinkedHashMap<Long,Float> sorted_srednia = new LinkedHashMap<>();

        srednia.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x-> sorted_srednia.put(x.getKey(),x.getValue()));



        int liczba_zwracanych_przedmiotow = srednia.size() > 6 ? 6 : srednia.size();
        int j = 0;

        for(Map.Entry<Long,Float> entry: sorted_srednia.entrySet())
        {
            if(j==liczba_zwracanych_przedmiotow)
                break;
            else
            {
               Optional <Thing> przedmiot = thingRepository.findById(entry.getKey());
               Float sr = entry.getValue();
                ThingDTOpage1 przedmiot_rekomendowany = new ThingDTOpage1(przedmiot.orElse(null),sr);
                rekomendowane_zwrot.add(przedmiot_rekomendowany);
            }
            j++;
        }




        return rekomendowane_zwrot;
    }


}
