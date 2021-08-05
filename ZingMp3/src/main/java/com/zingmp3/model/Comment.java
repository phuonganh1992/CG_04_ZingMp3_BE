package com.zingmp3.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String content;

    LocalDate createDate;

    Long likes;

    @ManyToOne
    Song song;
    @ManyToOne
    User user;
}
