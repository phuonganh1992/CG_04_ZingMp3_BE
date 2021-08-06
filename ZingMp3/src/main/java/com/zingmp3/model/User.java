package com.zingmp3.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String name;

    @Email
    private String email;

    private String phoneNumber;

    private String image = "https://firebasestorage.googleapis.com/v0/b/spa-stay.appspot.com/o/img%2F1583085901039?alt=media&token=e396af18-3aa6-49ae-8ffc-22a55124b18a";

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "auth_provider")
//    private AuthenticationProvider authProvider;



    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String name, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.roles = roles;
    }

    public User(String username, String password, String name, String email, String phoneNumber, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }

    public User(String username, String password, String name, String email, String phoneNumber, String image, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.image = image;
        this.roles = roles;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public AuthenticationProvider getAuthProvider() {
//        return authProvider;
//    }
//
//    public void setAuthProvider(AuthenticationProvider authProvider) {
//        this.authProvider = authProvider;
//    }
}
