package user_manage.model;

import java.util.ArrayList;

import user_manage.model.entity.User;

public class UserRepository {
    ArrayList<User> userList = new ArrayList<>();

    public void addToList(User user) {
        userList.add(user);
    }

}
