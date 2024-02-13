package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min=5,max = 20)
    private String name;

    @NotEmpty(message = "Gender cannot be empty")
    private  String gender;

    @NotEmpty(message = "Email cannot be empty")
    @Email
    private  String email;

    @NotEmpty(message = "City cannot be empty")
    private  String city;

    @Min(value = 1, message = "Age must be greater than zero")
    private  int age;

    @NotEmpty(message = "Dateofbirth cannot be empty")
    private String dateOfBirth;

}
