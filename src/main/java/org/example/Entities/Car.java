package org.example.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Car {

    @Id
    private int car_Id;

    private String car_Model;

    @ManyToOne
    @JoinColumn(name = "car_Id")
    private Client client;

    @OneToMany(mappedBy = "car")
    private List<Rent> rent;

    public Car(String car_Model) {
        this.car_Model = car_Model;
    }

    public int getCar_Id() {
        return car_Id;
    }

    public void setCar_Id(int car_Id) {
        this.car_Id = car_Id;
    }

    public String getCar_Model() {
        return car_Model;
    }

    public void setCar_Model(String car_Model) {
        this.car_Model = car_Model;
    }

    public List<Rent> getRent() {
        return rent;
    }

    public void setRent(List<Rent> rent) {
        this.rent = rent;
    }
}
