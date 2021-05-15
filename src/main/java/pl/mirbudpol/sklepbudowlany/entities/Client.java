package pl.mirbudpol.sklepbudowlany.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.DTO.RegisteredClientDTO;
import pl.mirbudpol.sklepbudowlany.additionalClasses.ID;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity(name = "klienci")
public class Client extends ID {


    @Column(nullable = false)
    private String imie;

    @Column(nullable = false)
    private String nazwisko;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne(mappedBy = "klient", cascade = CascadeType.ALL)
    private Adress adres;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private RegisteredUser zarejestrowanyUzytkownik;

    @OneToMany(mappedBy = "klient")
    private List<Order> zamowienia = new ArrayList<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Rating> oceny = new ArrayList<>();


    public Client(RegisteredClientDTO dto) {
        this.imie = dto.getImie();
        this.nazwisko = dto.getNazwisko();
        this.email = dto.getEmail();
    }

}
