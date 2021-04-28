package com.example.demo.entities.project;

import com.example.demo.entities.Activity;
import com.example.demo.entities.client.Client;
import com.example.demo.helpers.AbstractId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "projects")
public class Project extends AbstractId {



    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "project")
    private List<Client> clients = new ArrayList<>();

    @ManyToMany(mappedBy = "projects")
    private Set<Activity> activity = new HashSet<>();

}
