package pl.mirbudpol.sklepbudowlany.entities;

import lombok.Getter;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.additionalClasses.ID;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
=======
import javax.persistence.*;
import java.util.ArrayList;
>>>>>>> origin/PSs_branch
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
<<<<<<< HEAD
    private Float cenaSprzedazy;
=======
    private Float CenaSprzedazy;
>>>>>>> origin/PSs_branch

    @Column(nullable = false)
    private Boolean czyArchiwalny;

<<<<<<< HEAD
    @OneToMany(mappedBy = "przedmiot")
    private List<ItemsOrders> przedmiotyZamowienia;

    @OneToMany(mappedBy = "przedmiot")
    private List<Images> zdjecia;
}
=======
    @OneToMany(mappedBy = "object", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "object", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<CategoryObject> categoryObjects  = new ArrayList<>();

}
>>>>>>> origin/PSs_branch
