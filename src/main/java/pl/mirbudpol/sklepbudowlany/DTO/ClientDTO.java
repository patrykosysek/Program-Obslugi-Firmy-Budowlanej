package pl.mirbudpol.sklepbudowlany.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 20)
   private String imie;

    @NotBlank
    @Size(min = 2, max = 20)
    private String nazwisko;

    @Email(message = "email should be valid")
    private String email;

    private AdressDTO adres;

     public ClientDTO(String imie,String nazwisko, String email){
        this(null,imie,nazwisko,email,null);}

}
