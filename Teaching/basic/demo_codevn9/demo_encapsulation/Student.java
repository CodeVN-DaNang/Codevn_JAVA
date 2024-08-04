public class Student {
    private int id;
    private String name;
    private int age;
    private String description;

    public Student(){

    }

    public Student(int id, String name, int age, String description){
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static void sayHello(String quest){
        System.out.println(quest);
    }

}