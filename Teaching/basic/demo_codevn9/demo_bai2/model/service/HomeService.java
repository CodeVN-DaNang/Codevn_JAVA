package model.service;

import java.util.ArrayList;

import model.entities.Home;
import model.repository.HomeRepo;


public class HomeService {
    HomeRepo homeRepo = new HomeRepo();

     public ArrayList<Home> getAll() {
        if (homeRepo.getAll().isEmpty()) {
            System.out.println("hello");
            return null;
        }
        return homeRepo.getAll();
    }

    public Home getByHomeNumber(String homeNumber) {
        if (homeRepo.getByHomeNumber(homeNumber) == null) {
            System.out.println("home number is not exist");
            return null;
        }
       return homeRepo.getByHomeNumber(homeNumber);
    }

    public void add(Home home) {
        homeRepo.add(home);
    }

    public void delete(String homeNumber) {
        homeRepo.delete(homeNumber);
    }

    public void update(Home newHome) {
        homeRepo.update(newHome);
    }

}
