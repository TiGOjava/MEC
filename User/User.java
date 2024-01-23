package com.MEC.User;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String FirstName;

    private String login;

    private String password;


    private String email;
}