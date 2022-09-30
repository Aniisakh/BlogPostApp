package com.example.blogpostapp.repository;

import com.example.blogpostapp.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Repository
public interface BlogRepository extends JpaRepository <BlogEntity, UUID> {
}
