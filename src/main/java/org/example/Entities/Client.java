package org.example.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Enable auto-increment
    private int client_Id;

    private String client_Name;

    @OneToMany(mappedBy = "client")
    private List<Rent> rents;

    @OneToOne(mappedBy = "client")
    private Review review;

    public Client() {
    }

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

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_Id=" + client_Id +
                ", client_Name='" + client_Name + '\'' +
                '}';
    }
}
