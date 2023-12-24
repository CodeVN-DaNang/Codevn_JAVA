public class SubjectLeader extends Teacher {
    private int timeWork;

    public SubjectLeader() {
    }

    public SubjectLeader(int id, String name, String age, String gender, String phone, String subject, String level,
            int timeWork) {
        super(id, name, age, gender, phone, subject, level);
        this.timeWork = timeWork;
    }

    public int getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(int timeWork) {
        this.timeWork = timeWork;
    }

    

}
