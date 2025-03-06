package org.example.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "rent")
public class Rent {

    @Id
    private int rent_Id;

    private double rent_Price; //se stabileste la momentul inchirierii
    private LocalDate start_Period;
    private LocalDate end_Period;

    @ManyToOne
    @JoinColumn(name = "client_Id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "car_Id")
    private Car car;


    public Rent() {
    }

    public Rent(double rent_Price, LocalDate start_Period, LocalDate end_Period) {
        this.rent_Price = rent_Price;
        this.start_Period = start_Period;
        this.end_Period = end_Period;
    }


    public int getRent_Id() {
        return rent_Id;
    }

    public void setRent_Id(int rent_Id) {
        this.rent_Id = rent_Id;
    }

    public double getRent_Price() {
        return rent_Price;
    }

    public void setRent_Price(double rent_Price) {
        this.rent_Price = rent_Price;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getStart_Period() {
        return start_Period;
    }

    public void setStart_Period(LocalDate start_Period) {
        this.start_Period = start_Period;
    }

    public LocalDate getEnd_Period() {
        return end_Period;
    }

    public void setEnd_Period(LocalDate end_Period) {
        this.end_Period = end_Period;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
