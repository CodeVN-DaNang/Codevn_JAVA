package model.service;

import model.entities.User;
import model.repo.UserRepo;

public class UserService {
    UserRepo userRepo = new UserRepo();

    public boolean checkUnique(String username){
        User newUser = userRepo.getByUsername(username);
        if (newUser == null) {
            return true;
        }
        return false;
    }

    public boolean doLogin(User user){
        User checkUser = userRepo.getByUsername(user.getUsername());
        if (checkUser != null) {
            if (checkUser.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public boolean doRegister(User user){
        if (checkUnique(user.getUsername())) {
            userRepo.addNewUser(user);
            return true;
        }
        return false;
    }
}
