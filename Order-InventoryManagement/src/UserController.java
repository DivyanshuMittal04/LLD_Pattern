import java.util.List;

public class UserController {
    List<User>userList;

    public UserController(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user){
        userList.add(user);
    }

    public void remove(User user){
        userList.remove(user);
    }

    public User getUser(int userId){
        for(User user : userList){
            if(user.getId() == userId){
                return user;
            }
        }
        return null;
    }

}
