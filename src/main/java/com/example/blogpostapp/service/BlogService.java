package com.example.blogpostapp.service;

import com.example.blogpostapp.entity.BlogEntity;
import com.example.blogpostapp.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogService {
    private BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public void createBlog(BlogEntity blogEntity) {
        blogRepository.save(blogEntity);
    };

    public List<BlogEntity> getAllBlogs() {
        List<BlogEntity> list=blogRepository.findAll();
        return list;
    };

    public void updateBlog(UUID id, BlogEntity blogEntity) {
        BlogEntity found=blogRepository.findById(id).orElseThrow(RuntimeException::new);
        if(found!=null)
            found.setTitle(blogEntity.getTitle());
            found.setBody(blogEntity.getBody());
            found.setDescription(blogEntity.getDescription());

            blogRepository.save(found);
    };

    public BlogEntity getBlogById(UUID id) {
        return blogRepository.getById(id);
    };

    public void removeBlogbyId(UUID id) {
        BlogEntity found=blogRepository.findById(id).orElseThrow(RuntimeException::new);
        if(found!=null)
            blogRepository.deleteById(id);
    };
}
