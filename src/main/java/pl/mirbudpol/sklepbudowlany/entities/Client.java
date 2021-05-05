package pl.mirbudpol.sklepbudowlany.entities;

import lombok.Getter;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.additionalClasses.ID;

import javax.persistence.*;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> origin/PSs_branch

@Getter
@Setter
@Entity(name = "klienci")
public class Client extends ID{


    @Column(nullable = false)
    private String imie;

    @Column(nullable = false)
    private String nazwisko;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne(mappedBy = "klient",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Adress adres;

    @OneToOne(mappedBy = "client")
    private RegisteredUser zarejestrowanyUzytkownik;

<<<<<<< HEAD
    @OneToMany(mappedBy = "klient")
    private List<Order> zamowienia;

=======
>>>>>>> origin/PSs_branch
}
