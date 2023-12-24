package main.model.entity;

public class ClasS {
    private int idClass;
    private String nameClass;
    private String startDate;
    private boolean status;
    
    public ClasS(int idClass, String nameClass, String startDate, boolean status) {
        this.idClass = idClass;
        this.nameClass = nameClass;
        this.startDate = startDate;
        this.status = status;
    }
    public ClasS(String nameClass, String startDate, boolean status) {
        this.nameClass = nameClass;
        this.startDate = startDate;
        this.status = status;
    }
    public int getIdClass() {
        return idClass;
    }
    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }
    public String getNameClass() {
        return nameClass;
    }
    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Class [ nameClass=" + nameClass + ", startDate=" + startDate + ", status="
                + status + "]";
    }
    
}
