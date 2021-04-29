package pl.mirbudpol.sklepbudowlany.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdressDTO {

    private Long id;

    @NotBlank
    private String kraj;

    @NotBlank
    private String kodPocztowy;

    @NotBlank
    private String miejscowosc;

    @NotBlank
    private String ulicaNrDomu;


    public AdressDTO(String kraj,String kodPocztowy,String miejscowosc,String ulicaNrDomu){
        this(null,kraj,kodPocztowy,miejscowosc,ulicaNrDomu);
    }


}
