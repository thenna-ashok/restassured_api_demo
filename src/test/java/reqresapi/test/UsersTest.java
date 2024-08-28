package reqresapi.test;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import reqresapi.endpoints.UserEndPoints;
import reqresapi.payload.UsersRecord;
import reqresapi.utilities.GenerateTestData;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class UsersTest {

    @BeforeAll
    public static void setupData(){
        //TODO - Setup before the test starts
    }

    @Test
    void testGetUser(){
        Response response = UserEndPoints.readUser(2);
        response.then().log().all();
        assertEquals(200, response.getStatusCode());
    }

    @Test
    void testCreateUser(){
        Response response = UserEndPoints.createUser(GenerateTestData.createNewUser());
        response.then().log().all();
        assertEquals( 201, response.getStatusCode());
    }

    @Test
    void testUpdateOrPatchUser(){
        UsersRecord usersRecord = GenerateTestData.createNewUser();
        Response response = UserEndPoints.updateUser(usersRecord, usersRecord.id());
        response.then().log().all();
        assertEquals( 200, response.getStatusCode());
    }

    @Test
    void testDeleteUser(){
        Response response = UserEndPoints.deleteUser(GenerateTestData.createNewUser().id());
        response.then().log().all();
        assertEquals( 204, response.getStatusCode());
    }

    public static void cleanUpData(){
        //TODO - Cleanup tasks if any
    }
}
