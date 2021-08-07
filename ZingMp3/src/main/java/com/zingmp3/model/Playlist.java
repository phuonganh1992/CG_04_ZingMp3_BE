package com.zingmp3.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "playlists")
public class Playlist {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    private String name;

    private String description;

    private String img;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Artist> artists;

    @ManyToOne
    private User user;



    public Playlist() {
    }

    public Playlist(Long id, String name, String description, String img, Set<Artist> artists, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
        this.artists = artists;
        this.user = user;
    }

    public Playlist(String name, String description, String img, Set<Artist> artists, User user) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.artists = artists;
        this.user = user;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
