package com.example.blogpostapp.controller;
import com.example.blogpostapp.entity.BlogEntity;
import com.example.blogpostapp.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/blogs")
@AllArgsConstructor

public class BlogController {
    private final BlogService blogService;

    @GetMapping
    public List<BlogEntity> getAllBlog() {
        return blogService.getAllBlogs();
    }

    @PostMapping("/register")
    public void createBlog(@RequestBody BlogEntity blogEntity) {
        blogService.createBlog(blogEntity);
    }

    @PutMapping("/{blogId}")
    public void updateBlog(@PathVariable("blogId") UUID id, @RequestBody BlogEntity blogEntity) {
        blogService.updateBlog(id, blogEntity);
    }

    @DeleteMapping("/delete/{blogid}")
    public void deleteBlogbyId(@PathVariable("blogid") UUID id) {
        blogService.removeBlogbyId(id);
    }

    @GetMapping("/find/{blogid}")
    public BlogEntity findbyId(@PathVariable("blogid") UUID id) {
      return blogService.getBlogById(id);
    }
}
