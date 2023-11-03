package apiTests.lesson8;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestTest {
    public static final String BASE_URL = "https://reqres.in/";

    @Test
    public void restTest(){


//        ____________________________________GET______________________________________
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

//        System.out.println(response.asString());
//
//        System.out.println(response.statusCode());

//        Assert.assertEquals(response.statusCode(), 200);

//        given()
//                .accept(ContentType.JSON)
//                .get(BASE_URL + "api/users?page=2")
//                .then()
//                .statusCode(200).log().all()
//                .body("data.id[1]", equalTo(8));
//
//        Response response1 = given()
//                .accept(ContentType.JSON)
//                .get(BASE_URL + "api/users?page=2")
//                .then()
//                .statusCode(200)
//                .extract().response();
//
//        Assert.assertEquals("Michael", response1.jsonPath().getString("data.first_name[0]"));
//____________________________________POST______________________________________
//        Map <String, String> user = new HashMap<>();
//
//        user.put("name", "Marian");
//        user.put("job", "aqa");
//
        JSONObject request = new JSONObject();
        request.put("name", "Marian");
        request.put("job", "aqa");
//
//        given()
//                .accept(ContentType.JSON)
//                .body(request.toJSONString())
//                .when()
//                .post(BASE_URL + "api/users")
//                .then()
//                .statusCode(201).log().body();

//        ____________________________________PUT______________________________________

//        given()
//                .accept(ContentType.JSON)
//                .body(request.toJSONString())
//                .when()
//                .put(BASE_URL + "api/users/2")
//                .then()
//                .statusCode(200).log().body();
//        ____________________________________DELETE______________________________________

            given()
                    .delete(BASE_URL + "api/users/2")
                    .then()
                    .statusCode(204).log().all();
    }
}
