package main.model.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import main.model.entity.Motor;

public class MotorRepository {
    private ArrayList<Motor> motors = new ArrayList<>();

    public ArrayList<Motor> findAllMotor() throws Exception {
        FileReader fr = new FileReader("/Users/vannhat/Documents/java/NHATTV_JAVA/teaching/shop_project/src/database/motor.txt");
        BufferedReader br = new BufferedReader(fr);
        String i = "";
        while (true) {
            i = br.readLine();
            if (i == null) {
                break;
            } else {
                String[] motorNgu = i.split(", ");
                int id = Integer.parseInt(motorNgu[0]);
                String name = motorNgu[1];
                Motor motor = new Motor(id, name);
                motors.add(motor);
            }
        }
        return motors;
    }

    public static boolean addCar() throws IOException {
        FileWriter writer = new FileWriter("/Users/vannhat/Documents/java/NHATTV_JAVA/teaching/shop_project/src/database/motor.txt");  
        BufferedWriter buffer = new BufferedWriter(writer);  
        buffer.write("");  
        buffer.close();  
        System.out.println("Success");  
        return true;
    }

    public static void main(String[] args) throws IOException {
        addCar();
    }
}
