package org.project.backend.model;
import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String text;
    private String author;

    // 기본 생성자와 필드를 포함한 생성자
    public Comment() {}

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
    }

    // Getter와 Setter 메서드
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
