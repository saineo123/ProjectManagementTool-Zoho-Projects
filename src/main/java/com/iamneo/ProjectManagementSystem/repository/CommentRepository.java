package com.iamneo.ProjectManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.ProjectManagementSystem.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

