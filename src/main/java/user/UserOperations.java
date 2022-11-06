package user;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;

public class UserOperations {
    User user;
    String accessToken;
    private final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/auth";
    private final String CREATE_USER = "/register";
    private final String DELETE_USER = "/user";

    public Map<String, String> createUser() {
        user = User.getRandomUser();
        accessToken = given()
                .header("Content-Type", "application/json")
                .baseUri(BASE_URL)
                .body(user)
                .when()
                .post(CREATE_USER)
                .then()
                .statusCode(SC_OK)
                .extract()
                .path("accessToken");

        Map<String, String> userData = new HashMap<>();
        userData.put("email", user.getEmail());
        userData.put("password", user.getPassword());
        return userData;
    }

    public void deleteUser() {
        given()
                .header("Authorization", accessToken)
                .baseUri(BASE_URL)
                .when()
                .delete(DELETE_USER)
                .then()
                .statusCode(SC_ACCEPTED);
    }
}
