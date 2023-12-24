package manage_student2.model;

public class Student {
    //ID, tên, ngày tháng nam sinh, quê quán, lóp, giói tinh, thuòc tinh la diém toán, diém ly, diém hóa._
    private String idStudent;
    private String nameStudent;
    private String birthday;
    private String hometown;
    private String classStudent;
    private String gender;
    private double math;
    private double physic;
    private double chemistry;

    // constructor  
    public Student(String idStudent, String nameStudent, String birthday, String hometown, String classStudent,
                    String gender, double math, double physic, double chemistry){
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.birthday = birthday;
        this.hometown = hometown;
        this.classStudent = classStudent;
        this.gender = gender;
        this.math = math;
        this.physic = physic;
        this.chemistry = chemistry;
    }

    // method
    public void checkType(){
        double avg = (this.math + this.physic + this.chemistry)/3;
        String type = "";
        if(avg < 5.0 && avg >= 0){
            type = "Trung binh";
        } else if (avg >= 5.0 && avg < 8.0){
            type = "Kha";
        } else if (avg >= 8.0 && avg <= 10){
            type = "Gioi";
        } else {
            return;
        }
        System.out.println(this.nameStudent + " la hoc sinh " + type);
    }

    public void checkMajor(){
        String major = "Chuyen toan";
        double max = math;
        if(this.math < 9.5){
            major = "";
        }
        if(max < this.physic && this.physic >= 9.5){
            max = this.physic;
            major = "Chuyen ly";
        }
        if(max < this.chemistry && this.chemistry >= 9.5){
            max = this.chemistry;
            major = "Chuyen hoa";
        }
        System.out.println(this.nameStudent + " la hoc sinh " + major);
        
    }

}
