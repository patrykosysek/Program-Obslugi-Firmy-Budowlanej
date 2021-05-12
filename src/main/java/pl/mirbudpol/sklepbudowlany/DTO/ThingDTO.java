package pl.mirbudpol.sklepbudowlany.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.entities.CategoryObject;
import pl.mirbudpol.sklepbudowlany.entities.ElectronicMaterial;
import pl.mirbudpol.sklepbudowlany.entities.Images;
import pl.mirbudpol.sklepbudowlany.entities.Thing;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThingDTO {

    private Long id;

    @NotBlank
    private String nazwa;
    @NotBlank
    private String opis;
    @NotNull
    private Float cenaZakupu;
    @NotNull
    private Integer iloscNaMagazynie;
    @NotNull
    private Float cenaSprzedazy;
    @NotNull
    private Boolean czyArchiwalny;

    private List<String> kategoriaId;
    private List<String> zdjecia;
    private List<String> materialyElektroniczne;


    public ThingDTO(String nazwa, String opis, Float cenaZakupu, Integer iloscNaMagazynie,
                    Float cenaSprzedazy, Boolean czyArchiwalny, List<String> kategoriaId) {
        this
                (null, nazwa, opis, cenaZakupu, iloscNaMagazynie, cenaSprzedazy, czyArchiwalny, kategoriaId, null, null);
    }

    public ThingDTO(String nazwa, String opis, Float cenaZakupu, Integer iloscNaMagazynie,
                    Float cenaSprzedazy, Boolean czyArchiwalny, List<String> kategoriaId, List<String> zdjecia) {
        this
                (null, nazwa, opis, cenaZakupu, iloscNaMagazynie, cenaSprzedazy, czyArchiwalny, kategoriaId, zdjecia, null);
    }

    public ThingDTO(String nazwa, String opis, Float cenaZakupu, Integer iloscNaMagazynie,
                    Float cenaSprzedazy, Boolean czyArchiwalny, List<String> kategoriaId, List<String> zdjecia, List<String> materialyElektroniczne) {
        this
                (null, nazwa, opis, cenaZakupu, iloscNaMagazynie, cenaSprzedazy, czyArchiwalny, kategoriaId, zdjecia, materialyElektroniczne);
    }


    public ThingDTO(Thing thing) {
        this.id = thing.getId();
        this.nazwa = thing.getNazwa();
        this.opis = thing.getOpis();
        this.cenaZakupu = thing.getCenaZakupu();
        this.cenaSprzedazy = thing.getCenaSprzedazy();
        this.czyArchiwalny = thing.getCzyArchiwalny();

        for (CategoryObject categoryObject : thing.getCategoryObjects()) {
            this.kategoriaId.add(categoryObject.getCategory().getNazwaKategorii());
        }

        for (Images images : thing.getZdjecia()) {
            this.zdjecia.add(images.getRef());
        }

        for (ElectronicMaterial electronicMaterial : thing.getMaterialyElektoniczne()) {
            this.materialyElektroniczne.add(electronicMaterial.getRef());
        }
    }


}
