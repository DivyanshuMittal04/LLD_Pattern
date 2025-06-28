package Group;

import User.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GroupController {
    List<Group> groupList;

    public List<Group> getAllGroups() {
        return groupList;
    }

    public void addGroup(Group group) {
        groupList.add(group);
    }

    public GroupController() {
        groupList = new ArrayList<>();
    }

    public Group getGroupById(String groupId) {
        for (Group group : groupList) {
            if (Objects.equals(group.getGroupId(), groupId)) {
                return group;
            }
        }
        return null;
    }

    public void createGroup(String groupId, String groupName, User createdBy) {
        Group group = new Group(groupName, groupId);
        group.addUser(createdBy);
        addGroup(group);
    }
}
