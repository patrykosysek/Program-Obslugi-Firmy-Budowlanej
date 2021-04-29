package pl.mirbudpol.sklepbudowlany.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Klienci")
public class Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idKlienta;

    String imie;

    String nazwisko;

    String email;
}
