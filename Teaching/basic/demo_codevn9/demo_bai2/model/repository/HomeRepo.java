package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entities.Home;


public class HomeRepo {

    ArrayList<Home> area = new ArrayList<>();

    public void read(){
        area.clear();
        try {
            FileReader fr = new FileReader("/Users/vannhat/Documents/Codevn_JAVA/Teaching/basic/demo_codevn9/demo_bai2/data/dataHome.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                int amountPeople = Integer.parseInt(arr[0]);
                String homeNumber = arr[1];
                Home home = new Home(amountPeople, homeNumber);
                area.add(home);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

   

    public void write() {
        try {
           FileWriter fw = new FileWriter("/Users/vannhat/Documents/Codevn_JAVA/Teaching/basic/demo_codevn9/demo_bai2/data/dataHome.txt");
           String line = "";
           for (Home home : area) {
                line += home.getAmountMembers() + "," + home.getHomeNumber() + "\n";
           }
           fw.write(line);
           fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Home> getAll() {
        read();
        return area;
    }

    public Home getByHomeNumber(String homeNumber) {
        read();
        for (Home home : area) {
            if (home.getHomeNumber().equals(homeNumber)) {
                return home;
            }
        }
        return null;
    }

    public void add(Home home) {
        read();
        area.add(home);
        write();
    }

    public void delete(String homeNumber) {
        read();
        for (Home home : area) {
            if (home.getHomeNumber().equals(homeNumber)) {
                area.remove(home);
            }
        }
        write();
    }

    public void update(Home newHome) {
        read();
        int count = 0;
        for (Home home : area) {
            if (home.getHomeNumber().equals(newHome.getHomeNumber())) {
                area.set(count, newHome);
                break;
            }
            count++;
        }
        write();
    }
}
