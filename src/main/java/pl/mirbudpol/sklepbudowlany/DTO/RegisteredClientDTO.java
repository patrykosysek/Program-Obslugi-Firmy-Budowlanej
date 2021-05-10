package pl.mirbudpol.sklepbudowlany.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.enums.Country;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
@Email
private String email;
@NotBlank
private Country kraj;
@NotBlank
private String kodPocztowy;
@Size(min = 3,max = 20)
private String miejscowosc;
@NotBlank
private String ulicaNrDomu;

@Size(min = 4,max = 16)
private String login;
@Size(min = 5,max = 20)
private String haslo;

public RegisteredClientDTO (String imie,String nazwisko,String email,Country kraj,String kodPocztowy, String miejscowosc,String ulicaNrDomu,String login,String haslo){
    this(null,imie,nazwisko,email,kraj,kodPocztowy,miejscowosc,ulicaNrDomu,login,haslo);
}


}
