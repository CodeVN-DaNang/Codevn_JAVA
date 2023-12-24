package model.entity;

public class ClasS {
    private String nameClass;
    private String typeClass;
    public ClasS(String nameClass, String typeClass) {
        this.nameClass = nameClass;
        this.typeClass = typeClass;
    }
    public String getNameClass() {
        return nameClass;
    }
    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
    public String getTypeClass() {
        return typeClass;
    }
    public void setTypeClass(String typeClass) {
        this.typeClass = typeClass;
    }
    @Override
    public String toString() {
        return "ClasS [nameClass=" + nameClass + ", typeClass=" + typeClass + "]";
    }
}
