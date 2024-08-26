package reqresapi.endpoints;

     /*
       GET - https://reqres.in/api/users?page=2
       POST - https://reqres.in/api/users
       PATCH/UPDATE - https://reqres.in/api/users/2
       DELETE - https://reqres.in/api/users/2
     */

public class Routes {
    public static String BASE_URL = "https://reqres.in/api";
    public static String GET_URL = BASE_URL + "/users/{id}";
    public static String POST_URL = BASE_URL + "/users";
    public static String PATCH_URL = BASE_URL + "/users/{id}";
    public static String DELETE_URL = BASE_URL + "/users/{id}";
}
