package com.example.demo.services.project;

import com.example.demo.entities.project.Project;
import com.example.demo.repositories.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    public Project create(String name) {
        final Project project = new Project();
        project.setName(name);
        return projectRepository.save(project);
    }

    public Project findById(Long id) {
        return (id != null) ? projectRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new) : null;
    }

}
