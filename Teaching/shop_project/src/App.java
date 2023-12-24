import main.controller.MotorController;

public class App {
    static MotorController motorController = new MotorController();
    public static void main(String[] args) throws Exception {
        motorController.displayMenuMotor();
    }
}
