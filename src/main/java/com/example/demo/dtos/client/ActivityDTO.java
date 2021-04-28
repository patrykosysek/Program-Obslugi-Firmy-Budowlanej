package com.example.demo.dtos.client;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ActivityDTO {

private Long id;

    @NotNull
    private Long activityId;
    private List<Long> projectId = new ArrayList<>();

    public ActivityDTO(Long activityId, List<Long>projectId){this(null,activityId,projectId);}

    public ActivityDTO(Long id, @NotNull Long activityId, List<Long> projectId) {
        this.id = id;
        this.activityId = activityId;
        this.projectId = projectId;
    }

    public ActivityDTO() {
    }
}
