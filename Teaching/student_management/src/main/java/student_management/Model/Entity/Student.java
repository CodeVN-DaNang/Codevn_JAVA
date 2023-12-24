package student_management.Model.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private String idStudent;
    private String nameStudent;
    private String email;
    private String phone;
    private double mark;
    private String typeStudentId;
}
