package org.example.Entities;

import jakarta.persistence.OneToMany;

public class Car {

    public int car_Id;
    public String car_Model;

    @OneToMany
    public Rent rent;
}
