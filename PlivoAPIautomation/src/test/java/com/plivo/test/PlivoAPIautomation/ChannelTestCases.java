package com.plivo.test.PlivoAPIautomation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ChannelTestCases {
	Faker faker = new Faker();
	String chanelName = faker.regexify("[a-z1-9_-]{80}");

	@BeforeTest
	public void setUpTest() throws IOException {
		RestAssured.baseURI = "https://slack.com/api";

	}

	// Create a channel
	@Test
	public void CreateChannel() {

		Response res = given()
				.header("Authorization",
						"Bearer " + "xoxp-735767383460-738099574455-793881556257-de9aee2129c7c25edeb30ea8b0451ae6")
				.queryParam("name", chanelName).log().all().when().post(ChannelResources.channelPath()).then()
				.assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
		String resString = res.asString();
		System.out.println("CreateChannel is " + resString);

	}

	// Join the new Channel
	@Test
	public void joinChannel() {
		Response res = given()
				.header("Authorization",
						"Bearer " + "xoxp-735767383460-738099574455-793881556257-de9aee2129c7c25edeb30ea8b0451ae6")
				.queryParam("name", chanelName).log().all().when().post(ChannelResources.joinChannelPath()).then()
				.assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
		String resString = res.asString();
		System.out.println("JoinChannel is " + resString);

	}

	// Rename the Channel
	@Test
	public void renameChannel() {
		Response res = given()
				.header("Authorization",
						"Bearer " + "xoxp-735767383460-738099574455-793881556257-de9aee2129c7c25edeb30ea8b0451ae6")
				.queryParam("channel", "CSYN3N7FZ").queryParam("name", "kjhyuuuiu").log().all().when()
				.post(ChannelResources.renameChannelPath()).then().assertThat().statusCode(200)
				.contentType(ContentType.JSON).extract().response();
		String resString = res.asString();
		System.out.println("RenameChannel is " + resString);

	}

	// List all the Channels
	@Test
	public void listAllChannels() {
		Response res = given()
				.header("Authorization",
						"Bearer " + "xoxp-735767383460-738099574455-793881556257-de9aee2129c7c25edeb30ea8b0451ae6")
				.log().all().when().get(ChannelResources.listChannelPath()).then().assertThat().statusCode(200)
				.contentType(ContentType.JSON)
				// .body("channels[0].name", equalTo("kjhyuuuiu"))
				.extract().response();
		String resString = res.asString();
		System.out.println("ListChannel is " + resString);

	}

	// Archive the Channels
	@Test
	public void archiveChannels() {
		Response res = given()
				.header("Authorization",
						"Bearer " + "xoxp-735767383460-738099574455-793881556257-de9aee2129c7c25edeb30ea8b0451ae6")
				.queryParam("channel", "CSLLPEKCH").log().all().when().post(ChannelResources.archiveChannelPath())
				.then().assertThat().statusCode(200).contentType(ContentType.JSON)

				.extract().response();
		String resString = res.asString();
		System.out.println("ArchieveChannel is " + resString);

	}

	// Validate the channel is archieved
	@Test
	public void vlidateArchiveChannels() {
		Response res = given()
				.header("Authorization",
						"Bearer " + "xoxp-735767383460-738099574455-793881556257-de9aee2129c7c25edeb30ea8b0451ae6")
				.log().all().when().get(ChannelResources.listChannelPath()).then().assertThat().statusCode(200)
				.contentType(ContentType.JSON).body("channels[0].is_archived", equalTo(true)).extract().response();
		String resString = res.asString();
		System.out.println("ValidateArchieveChannel is " + resString);

	}

}
