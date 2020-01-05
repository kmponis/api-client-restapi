package com.sample.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.restapi.model.Post;
import com.sample.restapi.service.OkHttpRestClientService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/okhttp/restclient/api/v1")
public class OkHttpRestClientController {

	@Autowired
	private OkHttpRestClientService okHttpRestClientService;

	@ApiOperation(value = "Get All Post list", response = ResponseEntity.class)
	@GetMapping(value = "/getAllPosts")
	public ResponseEntity<List<Post>> getAllPosts() {
		return okHttpRestClientService.getAllPosts();
	}

	@ApiOperation(value = "Get Post list by username", response = ResponseEntity.class)
	@GetMapping(value = "/getPostsByUsername")
	public ResponseEntity<List<Post>> getPostsByUsername(@RequestParam(value = "username") String username) {
		return okHttpRestClientService.getPostsByUsername(username);
	}

}
