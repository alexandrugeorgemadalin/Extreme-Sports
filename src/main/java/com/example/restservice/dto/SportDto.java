package com.example.restservice.dto;

import com.sun.istack.NotNull;

import java.util.Date;

public class SportDto {
    @NotNull
    private String name;

    @NotNull
    private Long localityID;

    @NotNull
    private Integer dailyCost;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLocalityID() {
        return localityID;
    }

    public Integer getDailyCost() {
        return dailyCost;
    }

    public void setDailyCost(Integer dailyCost) {
        this.dailyCost = dailyCost;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
