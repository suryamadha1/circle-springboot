package com.social.circle.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table
@Data
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follower_id")
    private Long id;

    @ManyToMany(mappedBy = "followers", cascade = CascadeType.ALL)
    private Set<User> following;
}
