package com.example.appbookselling_quadat.beans.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {
    private int id;
    private int bookId;
    private int customerId;
    private float rating;
    private String comment;
}
