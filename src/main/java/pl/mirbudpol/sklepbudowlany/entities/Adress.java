package pl.mirbudpol.sklepbudowlany.entities;

import lombok.Getter;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.additionalClasses.ID;
import pl.mirbudpol.sklepbudowlany.enums.Country;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "AdresyZamieszkania")
public class Adress extends ID {


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Country kraj;
    @Column(nullable = false)
    private String kodPocztowy;
    @Column(nullable = false)
    private String miejscowosc;
    @Column(nullable = false)
    private String ulicaNrDomu;

    @OneToOne
    @JoinColumn(name = "klient_id",referencedColumnName = "id")
    private Client klient;

}
