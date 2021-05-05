package pl.mirbudpol.sklepbudowlany.entities;

import lombok.Getter;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.additionalClasses.ID;

import javax.persistence.*;

@Setter
@Getter
@Entity(name = "przedmiotyZamowienia")
public class ItemsOrders extends ID {

    @Column(nullable = false)
    private Integer iloscPrzedmiotu;

    @Column(nullable = false)
    private Float cenaSprzedazy;


    @ManyToOne
    @JoinColumn(name = "zamowienie_id",nullable = false)
    private Order zamowienie;


    @ManyToOne
    @JoinColumn(name = "przedmiot_id",nullable = false)
    private Thing przedmiot;



}
