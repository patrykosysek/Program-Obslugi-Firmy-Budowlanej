package pl.mirbudpol.sklepbudowlany.entities;


import lombok.Getter;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.additionalClasses.ID;

import javax.persistence.*;

@Setter
@Getter
@Entity(name = "materiałyElektroniczne")
public class ElectronicMaterial extends ID {

    @Column(nullable = false)
    private String ref;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "przedmioty_id",nullable = false)
    private Thing thing;
}
