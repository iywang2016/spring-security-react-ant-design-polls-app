package com.example.polls.model;

import com.example.polls.model.audit.DateAudit;
import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

import org.checkerframework.checker.confidential.qual.*;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonConfidential private Long id;

    @NotBlank
    @Size(max = 40)
    @NonConfidential private String name;

    @NotBlank
    @Size(max = 15)
    @NonConfidential private String username;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    @NonConfidential private String email;

    @NotBlank
    @Size(max = 100)
    @Confidential private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<@Confidential Role> roles = new HashSet<@Confidential Role>();

    public User() {

    }

    public User(@NonConfidential String name, @NonConfidential String username, @NonConfidential String email, @Confidential String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public @NonConfidential Long getId() {
        return id;
    }

    public void setId(@NonConfidential Long id) {
        this.id = id;
    }

    public @NonConfidential String getUsername() {
        return username;
    }

    public void setUsername(@NonConfidential String username) {
        this.username = username;
    }

    public @NonConfidential String getName() {
        return name;
    }

    public void setName(@NonConfidential String name) {
        this.name = name;
    }

    public @NonConfidential String getEmail() {
        return email;
    }

    public void setEmail(@NonConfidential String email) {
        this.email = email;
    }

    public @Confidential String getPassword() {
        return password;
    }

    public void setPassword(@Confidential String password) {
        this.password = password;
    }

    public Set<@Confidential Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<@Confidential Role> roles) {
        this.roles = roles;
    }
}