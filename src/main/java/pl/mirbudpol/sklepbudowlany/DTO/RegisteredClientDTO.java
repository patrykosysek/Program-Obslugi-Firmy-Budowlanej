package pl.mirbudpol.sklepbudowlany.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.entities.Client;
import pl.mirbudpol.sklepbudowlany.enums.Country;

import javax.validation.constraints.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredClientDTO {


    private Long id;

    @Size(min = 2, max = 20)
    private String imie;
    @Size(min = 2, max = 20)
    private String nazwisko;
    @Email(message = "Email jest nieprawidłowy")
    private String email;

    @NotNull
    private Country kraj;
    @NotBlank(message = "Nieprawidłowy kod pocztowy")
    private String kodPocztowy;
    @NotBlank(message = "Nieprawidłowa miejscowość")
    private String miejscowosc;
    @NotBlank(message = "Nieprawidłowy numer domu")
    private String ulicaNrDomu;

    @Size(min = 4, max = 16, message = "Login powinien zawierać się w przedziale od 4 do 20 znaków")
    private String login;
    @Size(min = 5, max = 20, message = "Login powinien zawierać się w przedziale od 4 do 20 znaków")
    private String haslo;

    public RegisteredClientDTO(String imie, String nazwisko, String email, Country kraj, String kodPocztowy, String miejscowosc, String ulicaNrDomu, String login, String haslo) {
        this(null, imie, nazwisko, email, kraj, kodPocztowy, miejscowosc, ulicaNrDomu, login, haslo);
    }

    public RegisteredClientDTO(Client client) {

        this.id = client.getId();
        this.imie = client.getImie();
        this.nazwisko = client.getNazwisko();
        this.email = client.getEmail();
        this.kraj = client.getAdres().getKraj();
        this.kodPocztowy = client.getAdres().getKodPocztowy();
        this.miejscowosc = client.getAdres().getMiejscowosc();
        this.ulicaNrDomu = client.getAdres().getUlicaNrDomu();
        this.login = client.getZarejestrowanyUzytkownik().getLogin();
        this.haslo = "********";

    }


}
