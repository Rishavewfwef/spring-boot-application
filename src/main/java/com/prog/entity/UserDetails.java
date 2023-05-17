package com.prog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER_DETAILS")
@Getter
@Setter
@NoArgsConstructor
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private String gender;
    private String address;

    @Override
    public String toString() {
        return String.format(
                "UserDetails [ id = %s, username = %s, password = %s, gender = %s, address = %s ]",
                id,
                username,
                password,
                gender,
                address
        );
    }
}
