package pl.mirbudpol.sklepbudowlany.entities;

import lombok.Getter;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.additionalClasses.ID;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "przedmiot")
public class Thing extends ID {

    @Column(nullable = false)
    private String nazwa;

    @Column(nullable = false)
    private String opis;

    @Column(nullable = false)
    private Float cenaZakupu;

    @Column(nullable = false)
    private Integer iloscNaMagazynie;

    @Column(nullable = false)
    private Float cenaSprzedazy;


    @Column(nullable = false)
    private Boolean czyArchiwalny;




    @OneToMany(mappedBy = "przedmiot")
    private List<ItemsOrders> przedmiotyZamowienia = new ArrayList<>();

    @OneToMany(mappedBy = "thing", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Images> zdjecia = new ArrayList<>();

    @OneToMany(mappedBy = "thing", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ElectronicMaterial> materialyElektoniczne = new ArrayList<>();


    @OneToMany(mappedBy = "thing", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(mappedBy = "thing", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<CategoryObject> categoryObjects = new ArrayList<>();

}

