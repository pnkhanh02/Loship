package com.vti.loshipBE.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private Long id;

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    private String email;
    private String phone;
    private String address;
    private boolean sex;
    private int status;
}
