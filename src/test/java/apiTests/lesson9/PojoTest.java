package apiTests.lesson9;

import base.api.pojos.createUser.CreateUserRequest;
import base.api.pojos.createUser.CreateUserResponse;
import base.api.pojos.getPet.Pet;
import base.api.pojos.getUser.GetUserData;
import base.api.pojos.updateUser.UpdateUserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static base.api.utils.Specifications.*;
import static io.restassured.RestAssured.*;

public class PojoTest {
    public static final String BASE_URL = "https://reqres.in/";

    @Test
    public void getUsers() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(200));
        List<GetUserData> usersList = given()
                .when()
                .get("api/users?page=2")
                .then()
                .extract().body().jsonPath().getList("data", GetUserData.class);

        Assert.assertNotNull(usersList);

        List<String> ids = new ArrayList<>();
        List<String> avatars = new ArrayList<>();

        for (GetUserData user : usersList) {
            Assert.assertTrue(user.getEmail().contains("@reqres.in"));

            ids.add(user.getId().toString());
            avatars.add(user.getAvatar());
        }

        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }

    @Test
    public void createUser() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(201));

        CreateUserRequest request = new CreateUserRequest();

        request.setName("morpheus");
        request.setJob("leader");

        CreateUserResponse createUserResponse = given()
                .body(request)
                .when()
                .post("api/users")
                .then()
                .extract().as(CreateUserResponse.class);

        Assert.assertNotNull(createUserResponse);

        Assert.assertEquals(request.getName(), createUserResponse.getName());
        Assert.assertEquals(request.getJob(), createUserResponse.getJob());
    }

    @Test
    public void updateUser() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(200));

        CreateUserRequest requestUpdate = new CreateUserRequest("morpheus", "zion resident");

        UpdateUserResponse updateUserResponse = given()
                .body(requestUpdate)
                .when()
                .put("api/users/2")
                .then()
                .extract().as(UpdateUserResponse.class);

        Assert.assertEquals(requestUpdate.getName(), updateUserResponse.getName());
        Assert.assertEquals(requestUpdate.getJob(), updateUserResponse.getJob());

    }

    @Test
    public void getPetTest() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(200));

        Pet[] responsePet = given()
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
                .then()
                .log().body()
                .extract().as(Pet[].class);

//        List<Pet> list = Arrays.asList(responsePet);

        for (Pet pet : responsePet) {
            Assert.assertEquals(pet.getStatus(), "available");
        }


    }
}
