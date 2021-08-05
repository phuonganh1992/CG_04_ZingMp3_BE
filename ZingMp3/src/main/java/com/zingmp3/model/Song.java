package com.zingmp3.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String description;

    String img;

    LocalDate createDate;

    Long likes;

    Long views;

    @ManyToOne
    Artist artist;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<Playlist> playlists;

    @ManyToOne
    User user;

    public Song() {
    }

    public Song(Long id, String name, String description, String img, LocalDate createDate, Long likes, Long views, Artist artist, Set<Playlist> playlists, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
        this.createDate = createDate;
        this.likes = likes;
        this.views = views;
        this.artist = artist;
        this.playlists = playlists;
        this.user = user;
    }

    public Song(String name, String description, String img, LocalDate createDate, Long likes, Long views, Artist artist, Set<Playlist> playlists, User user) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.createDate = createDate;
        this.likes = likes;
        this.views = views;
        this.artist = artist;
        this.playlists = playlists;
        this.user = user;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }




    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long like) {
        this.likes = like;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long view) {
        this.views = view;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
