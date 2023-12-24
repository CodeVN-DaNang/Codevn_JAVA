package model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entities.User;

public class UserRepo {

    ArrayList<User> userList = new ArrayList<>();

    public void read() {
        userList.clear();
        try {
            FileReader fr = new FileReader("/Users/vannhat/Documents/NHATTV_JAVA/teaching/basic/user_management/data/user.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                String username = arr[0];
                String password = arr[1];
                User user = new User(username, password);
                userList.add(user);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void write(){
        try {
            FileWriter fw = new FileWriter("/Users/vannhat/Documents/NHATTV_JAVA/teaching/basic/user_management/data/user.txt");
            String line = "";
            for (User user : userList) {
                line = line + user.getUsername() + "," + user.getPassword() + "\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addNewUser(User user){
        read();
        userList.add(user);
        write();
    }

    public User getByUsername(String username){
        read();
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

}
