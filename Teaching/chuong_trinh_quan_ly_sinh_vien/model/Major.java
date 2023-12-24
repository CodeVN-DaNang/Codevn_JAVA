package chuong_trinh_quan_ly_sinh_vien.model;

public class Major {
    private int idMajor;
    private String nameMajor;
    
    public Major(int idMajor, String nameMajor) {
        this.idMajor = idMajor;
        this.nameMajor = nameMajor;
    }

    public Major(){}

    public int getIdMajor() {
        return idMajor;
    }
    public void setIdMajor(int idMajor) {
        this.idMajor = idMajor;
    }
    public String getNameMajor() {
        return nameMajor;
    }
    public void setNameMajor(String nameMajor) {
        this.nameMajor = nameMajor;
    }

    public String displayMajor() {
        return "Major [idMajor=" + idMajor + ", nameMajor=" + nameMajor + "]";
    }

}
