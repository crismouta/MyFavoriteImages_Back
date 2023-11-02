package com.factoriaf5.myfavoriteimages.domain.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="images")
@Data
public class MyImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    @Column(length = 1000)
    private String description;
    private String image;

    public MyImage() {
    }

    public MyImage(Long id, String title, String description, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public MyImage(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

}
