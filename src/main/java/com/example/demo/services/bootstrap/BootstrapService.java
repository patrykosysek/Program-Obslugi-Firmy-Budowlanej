package com.example.demo.services.bootstrap;

import com.example.demo.dtos.client.ClientDTO;
import com.example.demo.entities.project.Project;
import com.example.demo.services.client.ClientService;
import com.example.demo.services.project.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Slf4j
@RequiredArgsConstructor
@Service
public class BootstrapService {

    private final ClientService clientService;
    private final ProjectService projectService;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        log.info("Bootstrap start");

        populateDatabase();

        log.info("Bootstrap end");
    }

    public void populateDatabase() {
        if (clientService.count() != 0) {
            return;
        }

        final Project project = projectService.create("Project");

        IntStream.range(0, 10).forEach(i -> {
            final ClientDTO dto = new ClientDTO(
                    RandomStringUtils.random(10, true, false),
                    (i % 2) == 0 ? project.getId() : null
            );
            clientService.create(dto);
        });
    }

}
