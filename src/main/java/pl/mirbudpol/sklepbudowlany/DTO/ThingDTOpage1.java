package pl.mirbudpol.sklepbudowlany.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.entities.Images;
import pl.mirbudpol.sklepbudowlany.entities.Thing;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThingDTOpage1 {

    private  Long id;

    private String nazwa;
    private Integer iloscNaMagazynie;
    private Float cenaSprzedazy;

    private String zdjecia;
    private Float ocena;


    public ThingDTOpage1(Thing thing,Float sr)
    {
     this(thing.getId(), thing.getNazwa(), thing.getIloscNaMagazynie(), thing.getCenaSprzedazy(),thing.getZdjecia().get(0).getRef(),sr);
    }

}
