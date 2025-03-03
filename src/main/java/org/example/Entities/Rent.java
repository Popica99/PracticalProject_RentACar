package org.example.Entities;

import jakarta.persistence.OneToMany;

import java.time.LocalDate;

public class Rent {

    public int rent_Id;
    public double rent_Price;
    public LocalDate rent_Period;

    @OneToMany
    public Car car;

}
