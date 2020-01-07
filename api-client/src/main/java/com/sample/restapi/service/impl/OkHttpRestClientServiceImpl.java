package com.sample.restapi.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.sample.restapi.model.Post;
import com.sample.restapi.service.OkHttpRestClientService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@Service
public class OkHttpRestClientServiceImpl implements OkHttpRestClientService {

	private static OkHttpClient client = new OkHttpClient();

	private static final String BASE_URI = "https://f4qwedrg34.execute-api.eu-west-1.amazonaws.com/dev";
	private static final String X_API_KEY = "x-api-key";
	private static final String API_KEY = "ZrbK7UJyit9PqbCIgqItwlVrIrUU47D8MUCSEIof";

	@Override
	public ResponseEntity<List<Post>> getAllPosts() {
		Request request = new Request.Builder().url(BASE_URI + "/getAllPosts").get().build();

		JsonObject jsonObject = getJsonObject(request);
		if (null == jsonObject) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		JsonArray jsonArray = null != jsonObject.get("posts") ? jsonObject.get("posts").getAsJsonArray() : new JsonArray();
		List<Post> posts = getGson().fromJson(jsonArray, new TypeToken<ArrayList<Post>>() {
		}.getType());

		return ResponseEntity.status(HttpStatus.OK).body(posts);
	}

	@Override
	public ResponseEntity<List<Post>> getPostsByUsername(String username) {
		Request request = new Request.Builder().url(BASE_URI + "/getPostByUsername?username=" + username).get()
				.addHeader(X_API_KEY, API_KEY).build();

		JsonObject jsonObject = getJsonObject(request);
		if (null == jsonObject) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		JsonArray jsonArray = null != jsonObject.get("posts") ? jsonObject.get("posts").getAsJsonArray() : new JsonArray();

		// Get a list of Post's using TypeToken object
		List<Post> posts = getGson().fromJson(jsonArray, new TypeToken<ArrayList<Post>>() {
		}.getType());

		return ResponseEntity.status(HttpStatus.OK).body(posts);
	}

	/**
	 * Get JsonObject from request using OkHttp
	 * 
	 * @param request
	 * @return JsonObject
	 */
	private JsonObject getJsonObject(Request request) {
		try {
			Response response = client.newCall(request).execute();
			JsonParser parser = new JsonParser();
			JsonElement jsonElement = parser.parse(response.body().string());
			return jsonElement.getAsJsonObject();
		} catch (IOException e) {
			System.out.println("Unable to retrieve JsonObject from request");
			return null;
		}
	}

	/**
	 * Get Gson object to deserialize with LocalDateTime field
	 * 
	 * @return Gson object
	 */
	private Gson getGson() {
		// Formatter will depend on input Date format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

		return new GsonBuilder()
				.registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type,
						jsonDeserializationContext) -> LocalDateTime.parse(json.getAsJsonPrimitive().getAsString(), formatter))
				.create();
	}

}
