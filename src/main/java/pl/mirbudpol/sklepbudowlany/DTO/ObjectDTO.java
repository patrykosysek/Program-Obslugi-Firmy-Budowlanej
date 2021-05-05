package pl.mirbudpol.sklepbudowlany.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObjectDTO {

    private  Long id;

    private String nazwa;
    private String opis;
    private Float cenaZakupu;
    private Integer iloscNaMagazynie;
    private Float cenaSprzedazy;
    private Boolean czyArchiwalny;

    private List<Long> przedmiotyZamowieniaId;
    private List<Long> zdjeciaId;


}
