package com.example.codeupspringblog.controllers;
import com.example.codeupspringblog.models.Post;
import com.example.codeupspringblog.models.User;
import com.example.codeupspringblog.repositories.PostRepository;
import com.example.codeupspringblog.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostRepository postDao;
    private UserRepository userDao;

    @GetMapping("")
    public String posts(Model model){
        List<Post> posts = postDao.findAll();

        model.addAttribute("posts",posts);
        return "/posts/index";
    }

    @GetMapping("/{id}")
    public String showSinglePost(@PathVariable Long id, Model model){

        Optional<Post> optionalPost = postDao.findById(id);
        if(optionalPost.isEmpty()) {
            System.out.printf("Post with id " + id + " not found!");
            return "home";
        }

        model.addAttribute("post", optionalPost.get());
        return "posts/show";
    }

    @GetMapping("/create")
    public String showCreate() {
        return "/posts/create";
    }

    @PostMapping("/create")
    public String doCreate(@RequestParam String title, @RequestParam String body) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);

        User loggedInUser = userDao.findById(1L).get();
        post.setUser(loggedInUser);

        postDao.save(post);

        return "redirect:/posts";
    }


}
