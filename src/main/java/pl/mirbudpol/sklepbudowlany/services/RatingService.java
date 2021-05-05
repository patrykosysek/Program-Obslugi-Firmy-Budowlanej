package pl.mirbudpol.sklepbudowlany.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mirbudpol.sklepbudowlany.DTO.RatingDTO;
import pl.mirbudpol.sklepbudowlany.entities.Rating;
import pl.mirbudpol.sklepbudowlany.repositories.RatingRepository;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Transactional
    public Rating createRating(RatingDTO dto) {
        final Rating rating = new Rating();
        rating.setClient(null);
        rating.setOcena(dto.getOcena());
        rating.setKomentarz(dto.getKomentarz());
        rating.setObject(null);

        return ratingRepository.save(rating);
    }

}
