package com.codeup.spring.controllers;

import com.codeup.spring.daos.PostsRepository;
import com.codeup.spring.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {
    private PostsRepository postDao;

    public PostController(PostsRepository postsRepository){
        postDao = postsRepository;
    }
    @GetMapping("/posts")
//    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String index(Model model){
        ArrayList<Post> adsList = new ArrayList<>();
        adsList.add(new Post("Sunday", "Tired"));
        adsList.add(new Post("Monday", "Still Tired"));
        adsList.add(new Post("Tuesday", "Ope, tired again"));
        adsList.add(new Post("Wednesday", "Wow, you guessed it"));
        model.addAttribute("noPostsFound", adsList.size() == 0);
        model.addAttribute("ads", adsList);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String show(@PathVariable long id, Model model){
        model.addAttribute("postId", id);
        model.addAttribute("post", new Post("Weather", "Hot"));
        return "/posts/show" + id;
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
