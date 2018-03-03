package com.example.demo.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UnitOfMeasureCommand {
    private Long id;
    private String description;

    public UnitOfMeasureCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}