package User;

public class UserController {
    UserService userService;

    public UserController() {
        userService = new UserService();
    }

    public void addUser(UserDO userDO){
        userService.addUser(userDO);
    }

    public UserDO getUser(int id){
        return userService.getUserById(id);
    }
}
