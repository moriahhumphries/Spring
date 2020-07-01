package com.codeup.spring.models;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @OneToOne
    private User owner;

    public Post() {
    }

    public Post(String title, String body, User owner){
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public Post(long id, String title, String body, User owner){
        this.id = id;
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public Post(String title, String description, User currentUser, Object o, Object o1) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getBody(){
        return this.body;
    }

    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    public void setBody(String newBody){
        this.body = newBody;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}