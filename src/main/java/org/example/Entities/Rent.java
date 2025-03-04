package org.example.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "rent")
public class Rent {

    @Id
    private int rent_Id;

    private double rent_Price; //se stabileste la momentul inchirierii
    private LocalDate rent_Period;

    @ManyToOne
    @JoinColumn(name = "client_Id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "car_Id")
    private Car car;

    @OneToOne(mappedBy = "rent")
    private Review review;


    public Rent() {
    }

    public Rent(double rent_Price, LocalDate rent_Period) {
        this.rent_Price = rent_Price;
        this.rent_Period = rent_Period;
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

    public LocalDate getRent_Period() {
        return rent_Period;
    }

    public void setRent_Period(LocalDate rent_Period) {
        this.rent_Period = rent_Period;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "rent_Id=" + rent_Id +
                ", rent_Price=" + rent_Price +
                ", rent_Period=" + rent_Period +
                ", client=" + client +
                ", car=" + car +
                ", review=" + review +
                '}';
    }
}
