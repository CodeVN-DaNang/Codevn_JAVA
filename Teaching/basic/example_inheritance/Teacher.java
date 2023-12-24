public final class Teacher extends Person {
    private String subject;
    private String level;

    public Teacher() {
    }

    public Teacher(int id, String name, String age, String gender, String phone, String subject, String level) {
        super(id, name, age, gender, phone);
        this.subject = subject;
        this.level = level;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}
