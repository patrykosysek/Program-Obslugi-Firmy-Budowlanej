package pl.mirbudpol.sklepbudowlany.entities;

import lombok.Getter;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.additionalClasses.ID;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Oceny")
public class Rating extends ID{

    @Column(nullable = false)
    private Integer ocena;

    @Column(nullable = false)
    private String komentarz;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "klienci_idKlienta", nullable = false)
    private Object object;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "przedmioty_idPrzedmiotu", nullable = false)
    private Client client;
}
