package pl.mirbudpol.sklepbudowlany.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {

    Long id;

    @NotBlank(message = "Nieprawidłowy link do zdjęcia")
    String ref;

    public ImageDTO(String ref) {
        this(null, ref);
    }

}
