package org.example.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    private int review_Id;

    private String description_Review;

    @OneToOne
    @JoinColumn(name = "client_Id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "rent_Id")
    private Rent rent;


    public Review() {
    }

    public Review(String description_Review) {
        this.description_Review = description_Review;
    }

    public int getReview_Id() {
        return review_Id;
    }

    public void setReview_Id(int review_Id) {
        this.review_Id = review_Id;
    }

    public String getDescription_Review() {
        return description_Review;
    }

    public void setDescription_Review(String description_Review) {
        this.description_Review = description_Review;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "Review{" +
                "review_Id=" + review_Id +
                ", description_Review='" + description_Review + '\'' +
                ", client=" + client +
                ", rent=" + rent +
                '}';
    }
}
