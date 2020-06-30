//package com.codeup.blog.models;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name="categories")
//public class AdCategory {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(nullable = false)
//    private String name;
//
//    @ManyToMany(mappedBy = "categories")
//    private List<Post> ads;
//
//    public AdCategory() {
//    }
//
//    public AdCategory(String name, List<Post> ads) {
//        this.name = name;
//        this.ads = ads;
//    }
//
//    public AdCategory(long id, String name, List<Post> ads) {
//        this.id = id;
//        this.name = name;
//        this.ads = ads;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Post> getAds() {
//        return ads;
//    }
//
//    public void setAds(List<Post> ads) {
//        this.ads = ads;
//    }
//}
