package reqresapi.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reqresapi.endpoints.UserEndPoints;
import reqresapi.payload.UsersRecord;
import reqresapi.utilities.GenerateTestData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersTest {

    private static final Logger logger = LoggerFactory.getLogger(UsersTest.class);

    @BeforeAll
    public static void setupData(){
        logger.info("#### Starting the test #####");
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

    @AfterAll
    public static void cleanUpData(){
        logger.info("#### Finishing the test #####");
    }
}
