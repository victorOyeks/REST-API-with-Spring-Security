package com.example.sprintapiwithsecurity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private boolean enabled = true;
    private boolean credentialsExpired = false;
    private boolean expired = false;
    private boolean locked = false;
    @ManyToMany(fetch = EAGER, cascade = ALL)
    @JoinTable(
            name = "AccountRole",
            joinColumns = @JoinColumn(name = "accountId", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "roleId", referencedColumnName = "id")
    )
    private Set<Role> roles;
}
