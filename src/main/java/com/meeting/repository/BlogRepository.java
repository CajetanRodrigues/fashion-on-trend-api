package com.meeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meeting.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
