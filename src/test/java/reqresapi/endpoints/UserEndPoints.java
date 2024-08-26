package reqresapi.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import reqresapi.payload.Users;
import reqresapi.payload.UsersRecord;

import static io.restassured.RestAssured.given;

/**
 * This class is used to perform CRUD operations requests
 */
public class UserEndPoints {

    public static Response createUser(UsersRecord usersRecord) {
        Response response;
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(usersRecord)
                .when()
                .post(Routes.POST_URL);
        return response;
    }

    public static Response readUser(int id) {
        Response response;
        response = given()
                .pathParam("id" ,id)
                .when()
                .get(Routes.GET_URL);
        return response;
    }

    public static Response updateUser(UsersRecord usersRecord) {
        Response response;
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id", usersRecord.id())
                .body(usersRecord)
                .when()
                .patch(Routes.PATCH_URL);
        return response;
    }

    public static Response deleteUser(int id) {
        Response response;
        response = given()
                .pathParam("id" ,id)
                .when()
                .delete(Routes.DELETE_URL);
        return response;
    }
}
