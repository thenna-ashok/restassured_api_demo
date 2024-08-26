package reqresapi.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reqresapi.endpoints.UserEndPoints;
import reqresapi.payload.UsersRecord;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersTest {

    private static final Logger logger = LoggerFactory.getLogger(UsersTest.class);
    private static UsersRecord usersRecord;
    @BeforeAll
    public static void setupData(){
        logger.info("#### Starting the test #####");
        usersRecord = new UsersRecord(2, "Maxx@email.com", "Maxx", "Turbo", "avatarname");
    }

    @Test
    void testGetUser(){
        Response response = UserEndPoints.readUser(2);
        response.then().log().all();
        assertEquals(200, response.getStatusCode());
    }

    @Test
    void testCreateUser(){
        Response response = UserEndPoints.createUser(usersRecord);
        response.then().log().all();
        assertEquals( 201, response.getStatusCode());
    }

    @Test
    void testUpdateOrPatchUser(){
        Response response = UserEndPoints.updateUser(usersRecord);
        response.then().log().all();
        assertEquals( 200, response.getStatusCode());
    }

    @Test
    void testDeleteUser(){
        Response response = UserEndPoints.deleteUser(usersRecord.id());
        response.then().log().all();
        assertEquals( 204, response.getStatusCode());
    }

    @AfterAll
    public static void cleanUpData(){
        logger.info("#### Finishing the test #####");
    }
}
