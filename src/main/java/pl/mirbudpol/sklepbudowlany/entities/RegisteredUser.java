package pl.mirbudpol.sklepbudowlany.entities;

import lombok.Getter;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.additionalClasses.ID;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "ZarejestrowaniUzytkownicy")
public class RegisteredUser extends ID {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUzytkownika")
    private Long id;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String haslo;

    @Column(nullable = false)
    private int typUzytkownika;

    @Column(nullable = false)
    private boolean czyAktywne;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "klient_id", referencedColumnName = "id")
    private Client client;

}