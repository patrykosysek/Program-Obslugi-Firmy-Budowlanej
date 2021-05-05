package pl.mirbudpol.sklepbudowlany.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.entities.Thing;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThingDTO {

    private  Long id;

    private String nazwa;
    private String opis;
    private Float cenaZakupu;
    private Integer iloscNaMagazynie;
    private Float cenaSprzedazy;
    private Boolean czyArchiwalny;

    private List<String> kategoriaId;
    private List<String> zdjecia;
    private Float ocena;


    public ThingDTO(String nazwa, String opis, Float cenaZakupu, Integer iloscNaMagazynie,
                    Float cenaSprzedazy, Boolean czyArchiwalny,List<String> kategoriaId){this
            (null,nazwa,opis,cenaZakupu,iloscNaMagazynie,cenaSprzedazy,czyArchiwalny,kategoriaId,null,null);}

    public ThingDTO(String nazwa, String opis, Float cenaZakupu, Integer iloscNaMagazynie,
                    Float cenaSprzedazy, Boolean czyArchiwalny,List<String> kategoriaId,List<String> zdjecia){this
            (null,nazwa,opis,cenaZakupu,iloscNaMagazynie,cenaSprzedazy,czyArchiwalny,kategoriaId,zdjecia,null);}


    public ThingDTO(Thing thing)
    {
        this(thing.getId(),thing.getNazwa(),thing.getOpis(),thing.getCenaZakupu(),thing.getIloscNaMagazynie(),thing.getCenaSprzedazy(),thing.getCzyArchiwalny(),null,null,null);

    }


}
