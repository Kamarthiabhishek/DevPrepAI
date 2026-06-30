package com.devprep.devprepai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    @NotBlank(message = "First Name cannot be Blank")
    private String firstName;
    @NotBlank(message = "Last Name cannot be Blank")
    private String lastName;
    @NotBlank(message = "Email cannot be Blank")
    @Email(message = "Invalid email address")
    private String email;
    @Min(18)
    @Max(60)
    @NotNull(message = "Age cannot be Null")
    private Integer age;
}
