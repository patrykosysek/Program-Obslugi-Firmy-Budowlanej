package pl.mirbudpol.sklepbudowlany.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "AdresyZamieszkania")
public class Adress {

    @Id
    @Column(name = "klient_id")
    private Long id;

    @Column(nullable = false)
    private String kraj;
    @Column(nullable = false)
    private String kodPocztowy;
    @Column(nullable = false)
    private String miejscowosc;
    @Column(nullable = false)
    private String ulicaNrDomu;

    @OneToOne
    @MapsId
    @JoinColumn(name = "klient_id")
    private Client klient;

}
