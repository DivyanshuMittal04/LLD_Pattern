package User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserController {
    List<User> userList;

    public UserController() {
        userList = new ArrayList<>();
    }

    public void addUser(User user){
        userList.add(user);
    }

    public User getUser(String userID){
        return userList.stream().filter(u -> Objects.equals(u.getId(), userID)).findFirst().orElse(null);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userList);
    }
}
