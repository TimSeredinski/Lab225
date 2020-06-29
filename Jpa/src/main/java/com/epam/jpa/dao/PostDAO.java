package com.epam.jpa.dao;

import com.epam.jpa.entity.Post;
import com.epam.jpa.entity.PostID;
import org.springframework.data.repository.CrudRepository;

public interface PostDAO extends CrudRepository<Post, PostID> {
}
