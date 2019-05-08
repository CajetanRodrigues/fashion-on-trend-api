package com.meeting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.meeting.model.Blog;
import com.meeting.repository.BlogRepository;;

@RestController
@RequestMapping(value="/rest")
public class BlogController {

	 @Autowired
	 BlogRepository blogRepository;
	
	 @RequestMapping(value = "/get-blogs", method = RequestMethod.GET)
		public List<Blog> getBlogs() {
		 RestTemplate restTemplate = new RestTemplate();
		 ResponseEntity<List<Blog>> response = restTemplate.exchange(
		   "http://localhost:5000/",
		   HttpMethod.GET,
		   null,
		   new ParameterizedTypeReference<List<Blog>>(){});
		 List<Blog> blogs = response.getBody();
		 blogRepository.saveAll(blogs);
		return blogs;
		}
	 @RequestMapping(value = "/get-blogs-from-database", method = RequestMethod.GET)
		public List<Blog> getBlogsFromDatabase() {
		return  blogRepository.findAll();
		}
}
