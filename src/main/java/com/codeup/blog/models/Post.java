package com.codeup.blog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false)
    private String description;

    @OneToOne
    private User owner;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
//    private List<PostImage> images;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name="posts_categories",
//            joinColumns = {@JoinColumn(name = "post_id")},
//            inverseJoinColumns = {@JoinColumn(name = "category_id")}
//    )
//    private List<PostCategory> categories;

    // spring framework uses this empty constructor
    public Post() {}

    // insert
    public Post(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.owner = user;
//        this.images = images;
//        this.categories = categories;
    }

    // read
    public Post(long id, String title, String description, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.owner = user;
//        this.images = images;
//        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

//    public List<PostImage> getImages() {
//        return images;
//    }
//
//    public void setImages(List<PostImage> images) {
//        this.images = images;
//    }
//
//    public List<PostCategory> getCategories() {
//        return categories;
//    }
//
//    public void setCategories(List<PostCategory> categories) {
//        this.categories = categories;
//    }
}
