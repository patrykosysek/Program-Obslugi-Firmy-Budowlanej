package pl.mirbudpol.sklepbudowlany.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.enums.Country;

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
private  String imie;
@Size(min = 2,max = 20)
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

@Size(min = 4,max = 16,message = "Login powinien zawierać się w przedziale od 4 do 20 znaków")
private String login;
@Size(min = 5,max = 20,message = "Login powinien zawierać się w przedziale od 4 do 20 znaków")
private String haslo;

public RegisteredClientDTO (String imie,String nazwisko,String email,Country kraj,String kodPocztowy, String miejscowosc,String ulicaNrDomu,String login,String haslo){
    this(null,imie,nazwisko,email,kraj,kodPocztowy,miejscowosc,ulicaNrDomu,login,haslo);
}


}
