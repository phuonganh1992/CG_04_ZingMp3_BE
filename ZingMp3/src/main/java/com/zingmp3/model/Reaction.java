package com.zingmp3.model;

import javax.persistence.*;

@Entity
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long likes;

    private Long views;

    @ManyToOne
    private Song song;

    public Reaction() {
    }

    public Reaction(Long id, Long likes, Long views, Song song) {
        this.id = id;
        this.likes = likes;
        this.views = views;
        this.song = song;
    }

    public Reaction(Long likes, Long views, Song song) {
        this.likes = likes;
        this.views = views;
        this.song = song;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
