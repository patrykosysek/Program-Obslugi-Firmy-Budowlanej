package pl.mirbudpol.sklepbudowlany.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.entities.Client;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredUserDTO {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 20)
    private String login;

    @NotBlank
    @Size(min = 2, max = 20)
    private String haslo;

    @NotBlank
    private int typUzytkownika;

    @NotBlank
    private boolean czyAktywne;

    private Client client;

    public RegisteredUserDTO(String login, String haslo, int typUzytkownika, boolean czyAktywne) {
        this(null, login, haslo, typUzytkownika, czyAktywne, null);
    }

}
