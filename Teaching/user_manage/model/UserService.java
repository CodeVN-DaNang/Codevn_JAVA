package user_manage.model;

import user_manage.model.entity.User;

public class UserService {
    UserRepository userRepository;
    public void addUser(User user) {
        userRepository.addToList(user);
    }
}
