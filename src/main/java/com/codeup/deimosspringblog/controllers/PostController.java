package com.codeup.deimosspringblog.controllers;

import com.codeup.deimosspringblog.dao.PostRepository;
import com.codeup.deimosspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController{
    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @RequestMapping(path = "/posts/index", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @RequestMapping(path = "/posts/show/{id}", method = RequestMethod.GET)
    public String viewPost(@PathVariable String id, Model model){
        Post post = postDao.getPostById(Long.parseLong(id));
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping(path = "/posts/create")
    public String create(){
        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String created(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        Post post = new Post(title, body);
        postDao.save(post);
        return "redirect:/posts/index";
    }

    @GetMapping(path = "/posts/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Post post = postDao.getPostById(Long.parseLong(id));
        model.addAttribute("editPost", post);
        return "posts/edit";
    }

    @PostMapping(path = "/posts/edit")
    public String editted(@RequestParam(name = "editTitle") String name, @RequestParam(name = "editBody") String body, @RequestParam(name = "editId") String id){
        Post post = new Post(Long.parseLong(id), name, body);
        postDao.save(post);
        return "redirect:/posts/index";
    }

    @PostMapping(path = "/posts/delete")
    public String delete(@RequestParam(name = "id") String id){
        postDao.deleteById(Long.parseLong(id));
        return "redirect:/posts/index";
    }
}
