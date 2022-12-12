package com.example.wind_plant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WindPlant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String city;

    public WindPlant(String city) {
        super();
        this.city = city;
    }

    public WindPlant() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
