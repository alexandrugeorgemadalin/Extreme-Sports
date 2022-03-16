package com.example.restservice.dto;

import com.sun.istack.NotNull;

public class RegionDto {

    @NotNull
    private String name;

    @NotNull
    private Long countryID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountryID() {
        return this.countryID;
    }
}
