/**
 * Student
 */
public class Student {
    // Số báo danh, họ tên, địa chỉ, mức ưu tiên
    private String code;
    private String name;
    private String address;
    private String priority;
    private Block block;

    public Student() {
    }

    public Student(String code, String name, String address, String priority, Block block) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.priority = priority;
        this.block = block;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return "Student [code=" + code + ", name=" + name + ", address=" + address + ", priority=" + priority
                + ", block=" + block + "]";
    }

}