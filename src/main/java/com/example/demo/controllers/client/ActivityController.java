package com.example.demo.controllers.client;


import com.example.demo.dtos.client.ActivityDTO;
import com.example.demo.dtos.client.ClientDTO;
import com.example.demo.services.activity.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Validated
@RequestMapping("/activities")
@RestController
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@Validated @RequestBody ActivityDTO dto) {
        activityService.create(dto);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Integer getAmountOfProjects(@PathVariable Long id)
    {
        return activityService.amountOfProjects(id);
    }
}
