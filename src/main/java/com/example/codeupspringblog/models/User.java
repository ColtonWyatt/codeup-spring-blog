package com.example.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "blog_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 255, nullable = false)
    private String userName;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private List<Post> posts;

}
