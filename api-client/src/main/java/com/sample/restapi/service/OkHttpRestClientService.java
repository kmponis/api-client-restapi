package com.sample.restapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sample.restapi.model.Post;

public interface OkHttpRestClientService {

	/**
	 * Getting A list of All Post's
	 * 
	 * @return A response entity with a list of Post's
	 */
	public ResponseEntity<List<Post>> getAllPosts();

	/**
	 * Getting A list of Post's by username
	 * 
	 * @param username
	 * @return A response entity with a list of Post's
	 */
	public ResponseEntity<List<Post>> getPostsByUsername(String username);

}
