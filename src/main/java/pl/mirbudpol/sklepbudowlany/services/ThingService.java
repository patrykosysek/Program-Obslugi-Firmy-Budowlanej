package pl.mirbudpol.sklepbudowlany.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mirbudpol.sklepbudowlany.DTO.ThingDTO;
import pl.mirbudpol.sklepbudowlany.entities.Thing;
import pl.mirbudpol.sklepbudowlany.repositories.ThingRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ThingService {

    private final ThingRepository thingRepository;

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

        return thingRepository.save(thing);

    }

    public List<ThingDTO> recommendedThings() {


        List<Thing> rekomednowane = thingRepository.findAllByCenaSprzedazy(100.0f);
        List<ThingDTO> rekomendowane_zwrot = new ArrayList<>();

        for(Thing thing: rekomednowane)
        {
            ThingDTO x = new ThingDTO(thing);
            rekomendowane_zwrot.add(x);
        }

        return rekomendowane_zwrot;
    }


}
