package com.example.appbookselling_quadat.beans.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
    private int id;
    private String username;
    private String password;
    private String email;
    private int userTypeId;
}
