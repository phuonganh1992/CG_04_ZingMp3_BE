package com.zingmp3.model;


import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "songs")
public class Song {
    public static final String SONG_IMG_DEFAULT = "https://firebasestorage.googleapis.com/v0/b/zingmp3-project.appspot.com/o/song_img_default.png?alt=media&token=272d7864-eef2-4e88-bbda-3e7373f286d3";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String img= SONG_IMG_DEFAULT;
    private String mp3;

    private LocalDate createDate;

    @ManyToOne
    private Artist artist;
    @ManyToOne
    private User user;

    public Song() {
    }

    public Song(Long id, String name, String description, String img,String mp3, Artist artist, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
        this.mp3 =mp3;
        this.createDate = LocalDate.now();
        this.artist = artist;
        this.user = user;
    }

    public Song(String name, String description, String img,String mp3,  Artist artist,  User user) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.mp3 =mp3;
        this.createDate = LocalDate.now();
        this.artist = artist;
        this.user = user;
    }

    public Song(String name, String description, String img, String mp3, Artist artist, User user) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.mp3 = mp3;
        this.artist = artist;
        this.user = user;
        this.createDate=LocalDate.now();
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
