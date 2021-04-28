package com.example.demo.entities;

import com.example.demo.entities.project.Project;
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
@Entity(name = "activities")
public class Activity extends AbstractId {

@Column(name = "activityid",nullable = false,unique = true)
    private Long activityId;

    @ManyToMany
    @JoinTable(name = "activity_project",
    joinColumns = @JoinColumn(name = "activity_id"),
    inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects = new HashSet<>();


}
