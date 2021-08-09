package com.zingmp3.model;


import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String img;
    private String mp3;

    private LocalDate createDate;

    @ManyToOne
    private Artist artist;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Playlist> playlists;

    @ManyToOne
    private User user;

    public Song() {
    }

    public Song(Long id, String name, String description, String img,String mp3, Artist artist, Set<Playlist> playlists, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
        this.mp3 =mp3;
        this.createDate = LocalDate.now();
        this.artist = artist;
        this.playlists = playlists;
        this.user = user;
    }

    public Song(String name, String description, String img,String mp3,  Artist artist, Set<Playlist> playlists, User user) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.mp3 =mp3;
        this.createDate = LocalDate.now();
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

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
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
