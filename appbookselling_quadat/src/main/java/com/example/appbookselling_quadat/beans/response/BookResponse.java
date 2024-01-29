package com.example.appbookselling_quadat.beans.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private int id;
    private String title;
    private int adminId;
    private int authorId;
    private int categoryId;
}
