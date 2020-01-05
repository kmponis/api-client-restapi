package com.sample.restapi.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sample.restapi.model.Post;
import com.sample.restapi.service.impl.OkHttpRestClientServiceImpl;

@RunWith(JUnitPlatform.class)
@SpringBootTest
public class OkHttpRestClientServiceTest {

	@InjectMocks
	private OkHttpRestClientService okHttpRestClientService = new OkHttpRestClientServiceImpl();

	@Test
	public void getAllPostsTest() {
		ResponseEntity<List<Post>> response = okHttpRestClientService.getAllPosts();

		assertTrue(response.getStatusCode().equals(HttpStatus.OK));
	}

	@Test
	public void getPostsByUsernameTest() {
		String username = "kostas";
		ResponseEntity<List<Post>> response = okHttpRestClientService.getPostsByUsername(username);

		assertTrue(response.getStatusCode().equals(HttpStatus.OK));
	}

}
