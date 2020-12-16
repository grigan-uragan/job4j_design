package serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UsageJSON {
    public static void main(String[] args) {
        final Contact contact = new Contact(123456, "+7(926) 555-55-55");
        final User user = new User("Bob", 30, contact, new String[]{"User", "Admin"}, true);
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(user));
        final String userJSON = "{"
                + "\"name\":\"Tom\","
                + "\"age\":35,"
                + "\"contact\":{"
                + "\"zipCode\":1234,"
                + "\"code\":\"+7(926)777-77-77\""
                + "},"
                + "\"role\":[\"User\",\"Admin\"],"
                + "\"sex\":true"
                + "}";
        final User userMod = gson.fromJson(userJSON, User.class);
        System.out.println(userMod);
    }
}
