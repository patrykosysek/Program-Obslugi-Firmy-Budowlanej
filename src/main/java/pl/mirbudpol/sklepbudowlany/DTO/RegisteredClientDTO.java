package pl.mirbudpol.sklepbudowlany.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.entities.Client;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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

    @NotBlank(message = "Nieprawidłowy kod pocztowy")
    private String kodPocztowy;
    @NotBlank(message = "Nieprawidłowa miejscowość")
    private String miejscowosc;
    @NotBlank(message = "Nieprawidłowy numer domu")
    private String ulicaNrDomu;

    @NotNull
    private String nrTelefonu;

    @Size(min = 5, max = 20, message = "Hasło powinien zawierać się w przedziale od 5 do 20 znaków")
    private String haslo;

    public RegisteredClientDTO(String imie, String nazwisko, String email, String kodPocztowy, String miejscowosc, String ulicaNrDomu, String nrTelefonu, String haslo) {
        this(null, imie, nazwisko, email, kodPocztowy, miejscowosc, ulicaNrDomu, nrTelefonu, haslo);
    }

    public RegisteredClientDTO(Client client) {

        this.id = client.getId();
        this.imie = client.getImie();
        this.nazwisko = client.getNazwisko();
        this.email = client.getEmail();
        this.nrTelefonu = client.getNrTelefonu();
        this.kodPocztowy = client.getAdres().getKodPocztowy();
        this.miejscowosc = client.getAdres().getMiejscowosc();
        this.ulicaNrDomu = client.getAdres().getUlicaNrDomu();
        this.haslo = "********";
    }
}
