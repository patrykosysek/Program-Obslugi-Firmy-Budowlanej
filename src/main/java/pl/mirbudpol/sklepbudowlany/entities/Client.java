package pl.mirbudpol.sklepbudowlany.entities;

import lombok.*;
import pl.mirbudpol.sklepbudowlany.additionalClasses.ID;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

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

    @OneToOne(mappedBy = "client",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Adress adres;

}
