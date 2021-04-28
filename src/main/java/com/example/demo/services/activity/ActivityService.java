package com.example.demo.services.activity;

import com.example.demo.dtos.client.ActivityDTO;
import com.example.demo.entities.Activity;
import com.example.demo.entities.project.Project;
import com.example.demo.repositories.activity.ActivityRepository;
import com.example.demo.services.project.ProjectService;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ActivityService {

    private final ProjectService projectService;
    private final ActivityRepository activityRepository;

    @Transactional
    public Activity create(ActivityDTO dto) {
       final   Activity activity = new Activity();

        dto.getProjectId().stream().filter( id -> id !=null)
                .forEach(id -> activity.getProjects().add(projectService.findById(id)));

        activity.setActivityId((dto.getActivityId()));
        return activityRepository.save(activity);
    }

    public Activity findById(Long id)
    {
        return activityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Integer amountOfProjects(Long id)
    {
        Activity activity = findById(id);
        return activity.getProjects().size();
    }

}
