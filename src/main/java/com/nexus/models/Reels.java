package com.nexus.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reels {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String video;

    @ManyToOne
    private User user;
}
