package pl.mirbudpol.sklepbudowlany.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private  Long id;

    @NotBlank
    @Size(min = 2, max = 20)
    private String nazwaKategorii;

    private List<Long> kategoriaPrzedmiotyId = new ArrayList<>();

    public CategoryDTO(String nazwaKategorii){
        this( null, nazwaKategorii, null);
    }
}