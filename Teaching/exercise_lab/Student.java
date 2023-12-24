package exercise_lab;

 class Student {
    private int id;
    private String name;
    private String className;
    private double math;
    private double physic;
    private double chemis;
    
    public Student(String name, String className, double math, double physic, double chemis) {
        this.name = name;
        this.className = className;
        this.math = math;
        this.physic = physic;
        this.chemis = chemis;
    }

    public String getTypeStudent() {
        if(getAvg() > 7.5){
            return "A";
        } else if (getAvg() >= 6 && getAvg() <= 7.5 ){
            return "B";
        } else if (getAvg() >= 4 && getAvg() < 6){
            return "C";
        } else {
            return "D";
        }
    }

    public double getAvg() {
        return (this.math + this.physic + this.chemis) /3;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public double getMath() {
        return math;
    }
    public void setMath(double math) {
        this.math = math;
    }
    public double getPhysic() {
        return physic;
    }
    public void setPhysic(double physic) {
        this.physic = physic;
    }
    public double getChemis() {
        return chemis;
    }
    public void setChemis(double chemis) {
        this.chemis = chemis;
    }
    
    



}
