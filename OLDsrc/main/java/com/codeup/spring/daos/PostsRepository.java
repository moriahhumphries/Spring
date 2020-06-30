package com.codeup.spring.daos;
import com.codeup.spring.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post, Long> {
    // HQL
    @Query("from Post where title like %:term% or body like %:term%")
    List<Post> searchByTitle(@Param("term") String term);

    // query methods
    Post findFirstByTitle(String title); // select * from ads where title = ? limit 1
}
