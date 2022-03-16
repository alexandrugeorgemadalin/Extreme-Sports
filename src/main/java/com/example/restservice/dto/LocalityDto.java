package com.example.restservice.dto;

import com.sun.istack.NotNull;

public class LocalityDto {

    @NotNull
    private String name;

    @NotNull
    private Long regionID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRegionID() {
        return regionID;
    }
}
