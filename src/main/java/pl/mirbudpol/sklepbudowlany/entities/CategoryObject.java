package pl.mirbudpol.sklepbudowlany.entities;

import lombok.Getter;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.additionalClasses.ID;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "kategorie_przedmioty")
public class CategoryObject extends ID{

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "kategoria_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "przedmiot_id", nullable = false)
    private Thing thing;
}
