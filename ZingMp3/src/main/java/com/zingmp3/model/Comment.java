package com.zingmp3.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private LocalDate createDate;

    private Long likes;

    @ManyToOne
    private Song song;
    @ManyToOne
    private User user;
}
