public class test1 {

    private String name;
    private String id;

    

    public void chao() {
        System.out.println("Hello");
    }

    public void chao(int id){
        System.out.println("Hello ba sang");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "test1 [name=" + name + ", id=" + id + "]";
    }
}
