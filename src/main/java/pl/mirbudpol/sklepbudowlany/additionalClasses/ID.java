package pl.mirbudpol.sklepbudowlany.additionalClasses;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class ID {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}