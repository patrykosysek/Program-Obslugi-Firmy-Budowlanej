package pl.mirbudpol.sklepbudowlany.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingDTO {

    private Long id;

    @NotNull
    private Integer ocena;

    @NotBlank
    @Size(min = 2, max = 20)
    private String komentarz;

    @NotNull
    private Long thingId;
    @NotNull
    private Long klientId;

    public RatingDTO(Integer ocena,String komentarz,Long thingId,Long klientId){
        this(null,ocena,komentarz,thingId,klientId);
    }

}
