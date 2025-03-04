package org.example.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {

    @Id
    private int client_Id;

    private String client_Name;

    @OneToMany(mappedBy = "client")
    private List<Car> car;


    public Client(String client_Name) {
        this.client_Name = client_Name;
    }

    public int getClient_Id() {
        return client_Id;
    }

    public void setClient_Id(int client_Id) {
        this.client_Id = client_Id;
    }

    public String getClient_Name() {
        return client_Name;
    }

    public void setClient_Name(String client_Name) {
        this.client_Name = client_Name;
    }

    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }
}
