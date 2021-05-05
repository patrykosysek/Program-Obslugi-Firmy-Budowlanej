package pl.mirbudpol.sklepbudowlany.entities;

import lombok.Getter;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.additionalClasses.ID;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "KategoriaPrzedmioty")
public class CategoryObject extends ID{

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "kategoria_idKategoriaProduktu", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "przedmioty_idrzedmiotu", nullable = false)
    private Object object;
}
