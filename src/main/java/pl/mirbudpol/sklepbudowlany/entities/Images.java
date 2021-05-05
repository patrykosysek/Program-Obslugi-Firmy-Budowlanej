package pl.mirbudpol.sklepbudowlany.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@IdClass(Images.class)
@Entity(name = "zdjecia")
public class Images implements Serializable {

    @ManyToOne
    @Id
    @JoinColumn(name = "przedmioty_id",nullable = false)
    private Object przedmiot;
}