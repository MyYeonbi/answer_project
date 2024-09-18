package org.project.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @Lob
    private String imageUrl;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    private double latitude;
    private double longitude;

    private int likes = 0;

    public void addLike() {
        this.likes++;
    }
    // Getter, Setter



}
