package com.sample.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.restapi.service.JerseyRestClientService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/jersey/restclient/api/v1")
public class JerseyRestClientController {

	@Autowired
	private JerseyRestClientService jerseyRestClientService;

	@ApiOperation(value = "Make getRequest call", response = ResponseEntity.class)
	@GetMapping(value = "/getRequest")
	public ResponseEntity<String> getRequest() {
		return jerseyRestClientService.getRequest();
	}

	@ApiOperation(value = "Make getRequest call with Authorization Token", response = ResponseEntity.class)
	@GetMapping(value = "/getRequestWithAuthorizationToken")
	public ResponseEntity<String> getRequestWithAuthorizationToken() {
		return jerseyRestClientService.getRequestWithAuthorizationToken();
	}

	@ApiOperation(value = "Make getRequest call with Basic Authentication", response = ResponseEntity.class)
	@GetMapping(value = "/getRequestWithBasicAuthentication")
	public ResponseEntity<String> getRequestWithBasicAuthentication() {
		return jerseyRestClientService.getRequestWithBasicAuthentication();
	}

	@ApiOperation(value = "Make postRequest call", response = ResponseEntity.class)
	@PostMapping(value = "/postRequest")
	public ResponseEntity<String> postRequest() {
		return jerseyRestClientService.postRequest();
	}

	@ApiOperation(value = "Make postRequest call with Authorization Token", response = ResponseEntity.class)
	@PostMapping(value = "/postRequestWithAuthorizationToken/{authToken}")
	public ResponseEntity<String> postRequestWithAuthorizationToken(@PathVariable("authToken") String authToken) {
		return jerseyRestClientService.postRequestWithAuthorizationToken(authToken);
	}

}
