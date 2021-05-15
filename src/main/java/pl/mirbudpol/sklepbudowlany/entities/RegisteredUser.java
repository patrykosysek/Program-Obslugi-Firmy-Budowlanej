package pl.mirbudpol.sklepbudowlany.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.DTO.RegisteredClientDTO;
import pl.mirbudpol.sklepbudowlany.additionalClasses.ID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "zarejestrowani_uzytkownicy")
public class RegisteredUser extends ID {


    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String haslo;

    @Column(nullable = false,name = "typ_uzytkownika")
    private Integer typUzytkownika;

    @Column(nullable = false,name = "czy_aktywne")
    private Boolean czyAktywne;

    @OneToOne
    @JoinColumn(name = "klient_id",referencedColumnName = "id")
    private Client client;

    public RegisteredUser(Integer role, RegisteredClientDTO dto){

        this.login = dto.getLogin();
        this.haslo = dto.getHaslo();
        this.typUzytkownika = role;
        this.czyAktywne = true;
    }

}

