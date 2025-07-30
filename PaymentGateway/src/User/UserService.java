package User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    static List<UserEntity> users = new ArrayList<>();

    public void addUser(UserDO userDo){
        UserEntity user = new UserEntity(userDo.getId(), userDo.getFirstName(), userDo.getMail());
        users.add(user);
    }

    public UserDO getUserById(int id) {
        for (UserEntity user : users) {
            if (user.getUserId() == id) {
                return convertUserToUserDO(user);
            }
        }
        System.out.println("User not found with id: " + id);
        return null;
    }

    private UserDO convertUserToUserDO(UserEntity user){
        return new UserDO(user.getUserId(), user.getName(), user.getEmail());
    }
}
