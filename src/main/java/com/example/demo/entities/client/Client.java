package com.example.demo.entities.client;

import com.example.demo.entities.project.Project;
import com.example.demo.helpers.AbstractId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "clients")
public class Client extends AbstractId {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

}
