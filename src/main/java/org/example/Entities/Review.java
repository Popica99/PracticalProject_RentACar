package org.example.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Review {

    @Id
    private int review_Id;

    private String description_Review;

    @OneToOne
    private Client client;

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
}
