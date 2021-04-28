package com.example.demo.dtos.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;

    @NotNull
    private String name;

    private Long projectId;

    public ClientDTO(String name, Long projectId) {
        this(null, name, projectId);
    }

}
