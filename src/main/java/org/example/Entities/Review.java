package org.example.Entities;

import jakarta.persistence.OneToOne;

public class Review {

    public int review_Id;
    public String description_Review;

    @OneToOne
    public Client client;
}
