package tests.chuck.norris;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ChuckNorrisTests {
    private static final Logger LOGGER = LogManager.getLogger();
    RequestSpecification requestSpecRandom = new RequestSpecBuilder()
            .setBaseUri("https://api.chucknorris.io/jokes/random")
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .build();
    RequestSpecification requestSpecNoUrl = new RequestSpecBuilder()
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .build();

    @Test
    public void getRandomJoke() {
        String randomJoke = RestAssured
                .given()
                .spec(requestSpecRandom)
                .when()
                .get()
                .path("value");
        LOGGER.info("random joke:  \n" + randomJoke);
    }

    @Test
    public void getCategories() {
        Response catList = RestAssured
                .given()
                .spec(requestSpecNoUrl)
                .get("https://api.chucknorris.io/jokes/categories");
        String categories = catList.asPrettyString();
        LOGGER.info(categories);
    }

    @Test
    public void getCategoryJoke() {
        Response categoryJoke = RestAssured
                .get("https://api.chucknorris.io/jokes/random?category=dev");
        String category = categoryJoke.path("categories").toString();
        String jokeValue = categoryJoke.path("value");
        LOGGER.info("\n Category: " + category + "\n Joke: " + jokeValue);
    }

    @Test
    public void searchJokesViaRandomText() {
        String searchVAlue = "fire";
        String searchJokesViaRandomText = RestAssured
                .get("https://api.chucknorris.io/jokes/search?query=" + searchVAlue)
                .body()
                .asPrettyString();
        LOGGER.info(searchJokesViaRandomText);
    }
}