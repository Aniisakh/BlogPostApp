package com.example.blogpostapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "blogs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, unique = true)

    private UUID id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "body")
    private String body;

    public BlogEntity(String title, String description, String body) {
        this.title = title;
        this.description = description;
        this.body = body;
    }
}
