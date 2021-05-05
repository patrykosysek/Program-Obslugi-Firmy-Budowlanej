package pl.mirbudpol.sklepbudowlany.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingDTO {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 20)
    private String ocena;

    @NotBlank
    @Size(min = 2, max = 20)
    private String komentarz;
}
