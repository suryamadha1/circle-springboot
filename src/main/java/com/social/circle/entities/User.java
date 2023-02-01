package com.social.circle.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Token> tokens;

    @JoinTable(
            name="User_Follower",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    @ManyToMany(cascade = { CascadeType.ALL })
    private Set<Follower> followers;

    public User(String name, String email, String password) {
        this.setEmail(email);
        this.setName(name);
        this.setPassword(password);
        this.setFollowers(new HashSet<Follower>());
    }

}
