package com.example.week7task.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_table", uniqueConstraints = @UniqueConstraint(columnNames = {"email", "username"}))
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstname;
    private String lastname;

    Post post = new Post();

    @Column(nullable = false)
    private String email;
    private String password;

    @Column(nullable = false)
    private String username;

    private String date_of_birth;
    private String gender;
    private String number;



}

