package com.codeup.spring.daos;
import com.codeup.spring.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Long>  {
}
