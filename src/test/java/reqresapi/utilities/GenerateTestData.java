package reqresapi.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reqresapi.payload.UsersRecord;

public class GenerateTestData {
    private static final Logger logger = LoggerFactory.getLogger(GenerateTestData.class);

    public static UsersRecord createNewUser(){
        UsersRecord usersRecord;
        usersRecord = new UsersRecord(TestDataHelper.generateRandomId(), "Maxx@email.com", "Maxx", "Turbo", "avatarname");
        System.out.println("*******  Generated Id: " + usersRecord.id() + "  ********");
        logger.info("Generated Id: {}", usersRecord.id());
        return usersRecord;
    }

    /*public static UsersRecord updateUser(){
        UsersRecord usersRecord;
        usersRecord = new UsersRecord(21, "Howddy@email.com", "Howddy", "Buddy", "avatarname");
        return usersRecord;
    }*/
}
