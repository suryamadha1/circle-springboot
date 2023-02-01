package com.social.circle.dto;

import com.social.circle.entities.Follower;
import com.social.circle.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private Set<Follower> followers;

    public UserResponse(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.followers = user.getFollowers();
        this.name = user.getName();
    }
}
