package com.codeup.spring.controllers;

import com.codeup.spring.daos.PostsRepository;
import com.codeup.spring.daos.UserRepository;
import com.codeup.spring.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@Controller
public class PostController {

    private PostsRepository postDao;
    private UserRepository userDao;

    public PostController(PostsRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
//    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String postIndex(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String show(@PathVariable long id, Model model){
        Post post = postDao.getOne(id);
        model.addAttribute("postId", postDao.getOne(id));
//        Post post = new Post(id,"Title 1", "Description 1");
//        model.addAttribute("title", post.getTitle());
//        model.addAttribute("body",post.getBody());
//        model.addAttribute("user", post.getOwner());
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String viewEditPostForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @RequestParam String title, @RequestParam String body) {
                Post selectPost = postDao.getOne(id);
                selectPost.setTitle(title);
                selectPost.setBody(body);
                postDao.save(selectPost);
                return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String formPost(){
        return "view the form for creating a post";
    }

    @RequestMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "create a new post";
    }

}
