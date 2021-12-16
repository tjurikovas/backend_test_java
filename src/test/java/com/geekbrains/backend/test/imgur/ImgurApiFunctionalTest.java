package com.geekbrains.backend.test.imgur;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ImgurApiFunctionalTest extends ImgurApiAbstractTest {

    private static String CURRENT_IMAGE_ID;

    ResponseSpecification responseSpecification = null;

    @BeforeEach
    void beforeTest() {
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(Matchers.lessThan(7000L))
                .build();
    }

    @Test
    @Order(1)
    void getAccountBase() {
        String userName = "tjurikovas";
        given()
                .spec(requestSpecification)
                .log()
                .all()
                .expect()
                .body("data.id", is(157845477))
                .log()
                .all()
                .when()
                .get("account/" + userName);
    }

    @Test
    @Order(2)
    void postImageTest() {
        CURRENT_IMAGE_ID = given()
                .spec(requestSpecification)
                .multiPart("image", getFileResource("img.jpg"))
                .formParam("name", "Picture")
                .formParam("title", "The best picture!!!)))")
                .log()
                .all()
                .expect()
                .body("data.size", is(46314))
                .body("data.type", is("image/jpeg"))
                .body("data.name", is("Picture"))
                .body("data.title", is("The best picture!"))
                .log()
                .all()
                .when()
                .post("upload")
                .body()
                .jsonPath()
                .getString("data.id");
    }

    @Test
    @Order(3)
    void deleteImageById() {
        given()
                .spec(requestSpecification)
                .log()
                .all()
                .expect()
                .body("status", is(200))
                .log()
                .all()
                .when()
                .delete("image/" + CURRENT_IMAGE_ID);
    }

    @Test
    void testCreateComment() {
        given()
                .spec(requestSpecification)
                .formParam("image_id", "6L1LCRK")
                .formParam("comment", "Ha - ha)))")
                .when()
                .post("comment")
                .prettyPeek()
                .then()
                .spec(responseSpecification)
                .log()
                .all();


    }

    @Test
    @Order(4)
    void postImageMyTest() {
        given()
                .spec(requestSpecification)
                .multiPart("image", getFileResource("myImages.jpg"))
                .formParam("description", "This is my picture!")
                .log()
                .all()
                .expect()
                .body("status", is(200))
                .body("data.type", is("image/jpg"))
                .log()
                .all()
                .when()
                .post("upload");
    }

    @Test
    @Order(5)
    void GetImageMy() {
        String imageHash = "Ydtr5xr";
        given()
                .spec(requestSpecification)
                .log()
                .all()
                .expect()
                .body("data.id", is("Ydtr5xr"))
                .body("data.type", is("image/jpeg"))
                .body("data.account_id", is(157845477))
                .body("data.link", is("https://i.imgur.com/Ydtr5xr.jpg"))
                .log()
                .all()
                .when()
                .get("image/" + imageHash)
                .prettyPeek()
                .then()
                .spec(responseSpecification);

    }

    @Test
    @Order(6)
    void GetGalleryMy() {
        String section = "top";
        String sort = "time";
        int page = 1;
        given()
                .spec(requestSpecification)
                .log()
                .all()
                .expect()
                .body("success", is(true))
                .log()
                .all()
                .when()
                .get("gallery/" + section + "/" + sort + "/window/" + page)
                .prettyPeek()
                .then()
                .spec(responseSpecification);
    }
}
