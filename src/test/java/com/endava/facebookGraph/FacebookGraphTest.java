package com.endava.facebookGraph;

import com.endava.facebookGraph.models.TestUser;
import com.endava.facebookGraph.util.EnvReader;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class FacebookGraphTest {
    private Faker faker = new Faker();

    @Test
    public void getAccountsTest(){

        given()
                .baseUri(EnvReader.getBaseuri())
                .auth().oauth2("455136538609782|4fdbc3c6f529deaf84edc82aee315790")
                .pathParam("app-id", "455136538609782")
                .log().all()
                .get("/v8.0/{app-id}/accounts/test-users")
                .prettyPeek()
                .then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void postTestUser() {

        TestUser testUser = new TestUser();
        testUser.setOwner_access_token(faker.internet().password());

        ValidatableResponse postResponse = given()
                .baseUri(EnvReader.getBaseuri())
                .auth().oauth2("455136538609782|4fdbc3c6f529deaf84edc82aee315790")
                .contentType(ContentType.JSON)
                .body(testUser)
                .pathParam("app-id", "455136538609782")
                .log().all()
                .post("/v8.0/{app-id}/accounts/test-users")
                .prettyPeek()
                .then().statusCode(HttpStatus.SC_OK);

        testUser.setUid(postResponse.extract().jsonPath().getString("id"));
        testUser.setOwner_access_token(postResponse.extract().jsonPath().getString("access_token"));
        testUser.setName("Madalin Bucur");
        testUser.setLogin_url(postResponse.extract().jsonPath().getString("login_url"));
        testUser.setEmail("madalinbucur80@ymail.com");
        testUser.setPassword("RestAssured2020");


        given()
                .baseUri(EnvReader.getBaseuri())
                .auth().oauth2(testUser.getOwner_access_token())
                .contentType(ContentType.JSON)
                .body(testUser)
                .pathParam("test-user-id", testUser.getUid())
                .post("/v8.0/{test-user-id}")
                .prettyPeek()
                .then().statusCode(HttpStatus.SC_OK);

    }

    // aici am incercat sa fac un get, sa pot vedea user-ul creat si modificat, dar n-am reusit
    @Test
    public void afterPutTest(){
        given()
                .baseUri(EnvReader.getBaseuri())
                .auth().oauth2("455136538609782|4fdbc3c6f529deaf84edc82aee315790")
                .get("/app/accounts/test-users")
                .prettyPeek()
                .then().statusCode(HttpStatus.SC_OK);
    }
}
