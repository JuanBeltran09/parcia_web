package com.example.proyectoweb.logic;

import java.time.LocalDate;

public class Activity {

    private Integer id;

    private String name;

    private String type;

    private LocalDate date;

    private Double percentage;

    public Activity(Integer id, String name, String type, LocalDate date, Double percentage) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.date = date;
        this.percentage = percentage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", birthday=" + date +
                ", percentage=" + percentage +
                '}';
    }
}
