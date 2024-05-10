package apiHandsOn;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class ApiRepo {

	String accessToken = "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";
	
	@Test(enabled = false)
	public void authorizationRepo() {
		
		JSONObject js = new JSONObject();

		js.put("name" , "Hello-manishaRana1212");
		js.put("description" , "This is your own repo");
		js.put("homepage" , "https://github.com");
		js.put("private" , false);
		js.put("is_template" , true);
		

		
		given().header("Authorization", "Bearer " + accessToken).body(js.toJSONString()).when().post("https://api.github.com/user/repos").then().statusCode(201).log().all();
	}
	
	@Test(enabled = false)
	public void updateARepository() {
		//https://api.github.com/repos/Manisha-Rana12/Hello-manisha
		JSONObject jo = new JSONObject();
		
		jo.put("name", "masai-school");
		jo.put("description", "This is your first repository");
		jo.put("homepage", "https://github.com");
		jo.put("private", true);
		jo.put("has_issues", true);
		jo.put("has_projects", true);
		jo.put("has_wiki", true);
		
		given().header("Authorization", "Bearer " + accessToken).body(jo.toJSONString()).when().patch("https://api.github.com/repos/Manisha-Rana12/Hello-manishaRana")
		.then().log().all();
		
	}
	@Test(enabled = false)
	public void deleteARepository() {
		given().header("Authorization", "Bearer " + accessToken).when().delete("https://api.github.com/repos/Manisha-Rana12/Hello").then().log().all();
	}
	@Test(enabled = false)
	public void getARepository() {
		given().header("Authorization", "Bearer" + accessToken).when().get("https://api.github.com/repos/Manisha-Rana12/Manisha-Rana1212").then().log().all();
		
	}
	@Test(enabled = false)
	public void listRepositories() {
		given().header("Authorization", "Bearer" + accessToken).when().get("https://api.github.com/users/Manisha-Rana12/repos").then().log().all();
	}
	@Test(enabled = false)
	public void listRepositoryLanguage() {
		given().header("Authorization", "Bearer" + accessToken).when().get("https://api.github.com/repos/Manisha-Rana12/Manisha-Rana1212/activity")
		.then().log().all();
	}
	@Test(enabled = false)
	public void listPublicRepositories() {
		given().header("Authorization", "Bearer" + accessToken).when().get("https://api.github.com/repositories")
		.then().statusCode(200).log().all();
	}
	@Test(enabled = false)
	public void CreateOrUpdateFileContent() {
		
		JSONObject js = new JSONObject();
			js.put("message", "hello_manisha");
			
		JSONObject committer =	new JSONObject();
		
		committer.put("name", "Manisha");
		committer.put("email", "manishasonamela@github.com");
		js.put("committer", committer); 
		js.put("content", "bXkgbmV3IGZpbGUgY29udGVudHM=");
		
		given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(js.toJSONString())
		.when()
		.put("https://api.github.com/repos/Manisha-Rana12/newRepo/contents/PATH").then().log().all();
			
		//0d5a690c8fad5e605a6e8766295d9d459d65de42
		
	}
	
	@Test(enabled = true)
	public void deleteAFile() {
		JSONObject js = new JSONObject();
		
		js.put("message", "hello_manisha");
		
		JSONObject committer = new JSONObject();
		
		committer.put("name", "manisha");
		committer.put("email", "manishasonamela@github.com");
		
		js.put("committer", committer);
		js.put("sha", "0d5a690c8fad5e605a6e8766295d9d459d65de42");
		
		given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(js.toJSONString()).when()
		.delete("https://api.github.com/repos/Manisha-Rana12/newRepo/contents/PATH").then().log().all();
	

	}
	
	@Test(enabled = false)
	public void listRepositoryTag() {
		given().header("Authorization", "Bearer" + accessToken).when().get("https://api.github.com/repos/Manisha-Rana12/Manisha-Rana1212/tags").then().statusCode(200).log().all();
	}
	
	@Test(enabled = false)
	public void autolink() {
		JSONObject js = new JSONObject();    //id: 4221446
		js.put("key_prefix","TICKET---");
		js.put("url_template", "https://example.com/TICKET?query=<num>");
		js.put("is_alphanumeric", true);
		
		given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(js.toJSONString())
		.when().post("https://api.github.com/repos/Manisha-Rana12/Manisha-Rana1212/autolinks").then().log().all();
	}
	
	@Test(enabled = false)
	public void getAllRepositoryTopic() {
		//repos/Manisha-Rana12/Manisha-Rana1212/topics
		given().header("Authorization", "Bearer " + accessToken).when().get("https://api.github.com/repos/Manisha-Rana12/Manisha-Rana1212/topics").then().log().all();
	}
	@Test(enabled = false)
	public void getAAutolinkReferance() {
		given().header("Authorization", "Bearer " + accessToken).when().get("https://api.github.com/repos/Manisha-Rana12/Manisha-Rana1212/autolinks/4221446").then().log().all();
	}
	@Test(enabled = false)
	public void deleteAutolink() {
		given().header("Authorization", "Bearer " + accessToken).when().delete("https://api.github.com/repos/Manisha-Rana12/Manisha-Rana1212/autolinks/4221446").then().log().all();
	}
	@Test(enabled = false)
	public void replaceRepoTopics() {
		JSONObject js = new JSONObject();
		List<String> string = List.of("octocat", "atom", "electron", "api");
		js.put("names", string);
		given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
		.body(js.toJSONString()).when().put("https://api.github.com/repos/Manisha-Rana12/Manisha-Rana1212/topics")
		.then().log().all();
		
	}
}

