package com.epam.jpa.dao;

import com.epam.jpa.entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CommentDAO extends CrudRepository<Comment, String> {
    @Query( value = "SELECT * FROM Comment c WHERE c.commentID = 2",
            nativeQuery = true)
    Comment findSecondComment();

    @Query(value = "SELECT c FROM Comment c JOIN FETCH c.post")
    List<Comment> findAllComments();
}
