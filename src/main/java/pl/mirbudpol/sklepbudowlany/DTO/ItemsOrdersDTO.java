package pl.mirbudpol.sklepbudowlany.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.entities.ItemsOrders;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemsOrdersDTO {

    @NotNull
    private Integer iloscPrzedmiotu;
    @NotNull
    private Float cenaSprzedazy;
    @NotNull
    private Long orderId;
    @NotNull
    ThingDTO item;


    public ItemsOrdersDTO(ItemsOrders itemsOrders){

        this.iloscPrzedmiotu = itemsOrders.getIloscPrzedmiotu();
        this.cenaSprzedazy = itemsOrders.getCenaSprzedazy();
        this.orderId = itemsOrders.getZamowienie().getId();
        this.item = new ThingDTO(itemsOrders.getPrzedmiot());


    }

}
