package main.model.service;

import java.util.ArrayList;

import main.model.entity.Motor;
import main.model.repository.MotorRepository;

public class MotorService {
    MotorRepository motorRepository = new MotorRepository();
    public void findAllMotor() throws Exception {
        ArrayList<Motor> motors = motorRepository.findAllMotor();
        if (motors.size() > 0) {
            for (int i = 0; i < motors.size(); i++) {
                System.out.println(motors.get(i).toString());
            }
        } else {
            System.out.println("Khong tim duoc gia tri nao");
        }
    }
}
