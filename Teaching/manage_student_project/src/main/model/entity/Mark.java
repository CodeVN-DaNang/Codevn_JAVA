package main.model.entity;

public class Mark {
    private int markId;
    private Subject subject;
    private Student student;
    private float mark;
    private int examTimes;
    public Mark(Subject subject, Student student, float mark, int examTimes) {
        this.subject = subject;
        this.student = student;
        this.mark = mark;
        this.examTimes = examTimes;
    }
    public Mark(int markId, Subject subject, Student student, float mark, int examTimes) {
        this.markId = markId;
        this.subject = subject;
        this.student = student;
        this.mark = mark;
        this.examTimes = examTimes;
    }
    
    @Override
    public String toString() {
        return "Mark [subject=" + subject.toString() + ", student=" + student.toString() + ", mark=" + mark
                + ", examTimes=" + examTimes + "]";
    }
    public int getMarkId() {
        return markId;
    }
    public void setMarkId(int markId) {
        this.markId = markId;
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public float getMark() {
        return mark;
    }
    public void setMark(float mark) {
        this.mark = mark;
    }
    public int getExamTimes() {
        return examTimes;
    }
    public void setExamTimes(int examTimes) {
        this.examTimes = examTimes;
    }
}
