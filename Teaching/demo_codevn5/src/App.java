import model.entity.Student;
import model.repository.StudentRepo;

public class App {
    public static void main(String[] args) throws Exception {
        StudentRepo studentRepo = new StudentRepo();
        for (Student student : studentRepo.getAllStudentbyid("Do")) {
            System.out.println(student.toString());
        }
    }
}
