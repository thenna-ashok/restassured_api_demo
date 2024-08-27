package reqresapi.utilities;

import java.util.Random;

public class TestDataHelper {
    public static int generateRandomId() {
        Random random = new Random();
        return random.nextInt(100);
    }
}
