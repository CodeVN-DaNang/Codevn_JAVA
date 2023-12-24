package manage_student.model;

public class Major {
    private String idMajor;
    private String nameMajor;
    private String subject1;
    private String subject2;
    private String subject3;

    public Major(){}

    public Major(String idMajor, String nameMajor, String subject1, String subject2, String subject3) {
        this.idMajor = idMajor;
        this.nameMajor = nameMajor;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }
    
    public String getIdMajor() {
        return idMajor;
    }
    public void setIdMajor(String idMajor) {
        this.idMajor = idMajor;
    }
    public String getNameMajor() {
        return nameMajor;
    }
    public void setNameMajor(String nameMajor) {
        this.nameMajor = nameMajor;
    }
    public String getSubject1() {
        return subject1;
    }
    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }
    public String getSubject2() {
        return subject2;
    }
    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }
    public String getSubject3() {
        return subject3;
    }
    public void setSubject3(String subject3) {
        this.subject3 = subject3;
    }
    @Override
    public String toString() {
        return "Major [nameMajor=" + nameMajor + ", subject1=" + subject1 + ", subject2=" + subject2 + ", subject3="
                + subject3 + "]";
    }
}
