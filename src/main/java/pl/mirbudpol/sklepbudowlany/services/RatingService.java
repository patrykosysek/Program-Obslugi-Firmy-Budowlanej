package pl.mirbudpol.sklepbudowlany.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mirbudpol.sklepbudowlany.DTO.RatingDTO;
import pl.mirbudpol.sklepbudowlany.entities.Client;
import pl.mirbudpol.sklepbudowlany.entities.Rating;
import pl.mirbudpol.sklepbudowlany.entities.Thing;
import pl.mirbudpol.sklepbudowlany.repositories.ClientRepository;
import pl.mirbudpol.sklepbudowlany.repositories.RatingRepository;
import pl.mirbudpol.sklepbudowlany.repositories.ThingRepository;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final ClientRepository clientRepository;
    private final ThingRepository thingRepository;

    @Transactional
    public Rating createRating(RatingDTO dto) {
        final Rating rating = new Rating();
        rating.setOcena(dto.getOcena());
        rating.setKomentarz(dto.getKomentarz());

        Thing thing = thingRepository.findById(dto.getThingId()).orElse(null);
        rating.setThing(thing);

        Client client = clientRepository.findById(dto.getKlientId()).orElse(null);
        rating.setClient(client);
        return ratingRepository.save(rating);
    }

}