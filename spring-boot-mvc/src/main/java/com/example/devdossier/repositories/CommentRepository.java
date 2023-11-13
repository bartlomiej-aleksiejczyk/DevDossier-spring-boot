package com.example.devdossier.repositories;

import com.example.devdossier.models.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}