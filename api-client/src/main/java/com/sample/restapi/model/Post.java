package com.sample.restapi.model;

import java.time.LocalDateTime;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Post {
	private String id;
	private LocalDateTime createdAt;
	private String title;
	private String description;
	private User user;
}
