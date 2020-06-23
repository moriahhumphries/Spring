package com.codeup.spring.models;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false)
    private String body;

    public Post(){

    }

    public class Post {
    private String title;
    private String body;
    private long id;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public Post(String title, String body, long id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
