package pl.mirbudpol.sklepbudowlany.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.entities.Thing;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThingDTOpage1 {

    private Long id;

    private String nazwa;
    private Integer iloscNaMagazynie;
    private Float cenaSprzedazy;

    private String zdjecia;
    private Float ocena;
    private boolean czyArchiwalny;


    public ThingDTOpage1(Thing thing, Float sr) {
        this(thing.getId(), thing.getNazwa(), thing.getIloscNaMagazynie(), thing.getCenaSprzedazy(), null, sr,  thing.getCzyArchiwalny());

        if (thing.getZdjecia().size() != 0)
            this.zdjecia = thing.getZdjecia().get(0).getRef();
        else
            this.zdjecia = "https://www.filtrowanie.com.pl/wp-content/uploads/2017/07/brak-zdjecia.png";

    }
}
