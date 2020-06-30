package com.codeup.blog.controllers;

import com.codeup.blog.daos.PostsRepository;
import com.codeup.blog.daos.UsersRepository;
import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostsController {

    // dependency injection
    private PostsRepository postsDao;
    private UsersRepository usersDao;

    public PostsController(PostsRepository postsRepository, UsersRepository usersRepository){
        postsDao = postsRepository;
        usersDao = usersRepository;
    }

    @GetMapping("/posts")
//    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String index(Model model){

        Post firstPost = postsDao.findFirstByTitle("psvita");
        System.out.println("firstPost.getId() = " + firstPost.getId());

        List<Post> postsList = postsDao.findAll();
        model.addAttribute("nopostsFound", postsList.size() == 0);
        model.addAttribute("posts", postsList);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model){
        Post post = postsDao.getOne(id);
        model.addAttribute("postId", id);
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String showForm(Model viewModel){
        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String save(@ModelAttribute Post postToBeSaved) {
        User currentUser = usersDao.getOne(1L);
        postToBeSaved.setOwner(currentUser);
        Post savedPost = postsDao.save(postToBeSaved);
        return "redirect:/posts/" + savedPost.getId();
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(Model model, @PathVariable long id){
        // find a post
        Post postToEdit = postsDao.getOne(id);
        model.addAttribute("post", postToEdit);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@ModelAttribute Post posttoEdit){
        User currentUser = usersDao.getOne(1L);
        posttoEdit.setOwner(currentUser);
        // save the changes
        postsDao.save(posttoEdit); // update posts set title = ? where id = ?
        return "redirect:/posts/" + posttoEdit.getId();
    }

    @PostMapping("/posts/{id}/delete")
    @ResponseBody
    public String destroy(@PathVariable long id){
        postsDao.deleteById(id);
        return "post deleted";
    }

    @GetMapping("/search")
    public String searchResults(Model model, @RequestParam(name = "term") String term){
        List<Post> posts = postsDao.searchByTitle(term);
        model.addAttribute("posts", posts);
        return "posts/index";
    }


}
