package com.example.jwt_tutorial.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "`user`")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username", length = 50, unique = true)
    @Setter
    private String username;

    @Column(name = "password", length = 100)
    @Setter
    private String password;

    @Column(name = "nickname", length = 50)
    @Setter
    private String nickname;

    @Column(name = "activated")
    @Setter
    private boolean activated;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    @Setter
    private Set<Authority> authorities;
}

