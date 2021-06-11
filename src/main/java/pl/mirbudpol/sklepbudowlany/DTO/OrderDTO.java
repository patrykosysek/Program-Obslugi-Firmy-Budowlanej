package pl.mirbudpol.sklepbudowlany.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.entities.ItemsOrders;
import pl.mirbudpol.sklepbudowlany.entities.Order;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    @NotNull
    private String dataZamowienia;
    @NotNull
    private Boolean czyZrealizowane;
    @NotNull
    private Float wartoscZamowienia;
    @NotNull
    private Long clientId;
    @NotNull
    private Long orderId;
    @NotNull
    private List<ItemsOrdersDTO> przedmiotyZamowienia = new ArrayList<>();


    public OrderDTO(Order order) {

        this.dataZamowienia = order.getDataZamowienia();
        this.czyZrealizowane = order.getCzyZrealizowane();
        this.wartoscZamowienia = order.getWartoscZamowienia();
        this.clientId = order.getKlient().getId();
        this.orderId = order.getId();
        for (ItemsOrders itemsOrders : order.getPrzedmiotyZamowienia()) {
            ItemsOrdersDTO dto = new ItemsOrdersDTO(itemsOrders);
            this.przedmiotyZamowienia.add(dto);
        }
    }

}
