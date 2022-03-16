package com.example.restservice.dto;

import com.sun.istack.NotNull;

public class CountryDto {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
