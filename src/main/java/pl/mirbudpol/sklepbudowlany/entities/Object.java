package pl.mirbudpol.sklepbudowlany.entities;

import lombok.Getter;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.additionalClasses.ID;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "przedmiot")
public class Object extends ID {

    @Column(nullable = false)
    private String nazwa;

    @Column(nullable = false)
    private String opis;

    @Column(nullable = false)
    private Float cenaZakupu;

    @Column(nullable = false)
    private Integer iloscNaMagazynie;

    @Column(nullable = false)
    private Float CenaSprzedazy;

    @Column(nullable = false)
    private Boolean czyArchiwalny;

    @OneToMany(mappedBy = "object", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "object", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<CategoryObject> categoryObjects  = new ArrayList<>();

}