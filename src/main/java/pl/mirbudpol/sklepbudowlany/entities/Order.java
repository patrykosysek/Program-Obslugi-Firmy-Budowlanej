package pl.mirbudpol.sklepbudowlany.entities;

import lombok.Getter;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.additionalClasses.ID;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.List;

@Setter
@Getter
@Entity(name = "zamowienia")
public class Order extends ID {

    @Column(nullable = false)
    private SimpleDateFormat dataZamowienia = new SimpleDateFormat("MM-dd-yyyy");

    @Column(nullable = false)
    private Boolean czyZrealizowane;

    @Column(nullable = false)
    private Float wartoscZamowienia;

    @ManyToOne
    @JoinColumn(name = "klient_id",nullable = false)
    private Client klient;

    @OneToMany(mappedBy = "zamowienie")
    private List<ItemsOrders> przedmiotyZamowienia;



}
