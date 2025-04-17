package Concurrency;

import java.util.ArrayList;
import java.util.List;

public class UserRepos {
    private static List<User> users = new ArrayList<User>();


    static {
        users.add(new User(1, "aditya_9"));
        users.add(new User(2, "nikhil_29"));
        users.add(new User(3, "harsh_5"));
    }

    public String getUserNameForUserId(int id) {
        User user = users.stream().filter(x -> x.getId() == id).findFirst().get();
        return user.getUsername();
    }
}
