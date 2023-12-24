package bai_4.model;


public class KhuPho {
    private String idKhuPho;
    private String tenKhuPho;

    public KhuPho(){}

    public KhuPho(String idKhuPho, String tenKhuPho) {
        this.idKhuPho = idKhuPho;
        this.tenKhuPho = tenKhuPho;
        
    }

    public String getIdKhuPho() {
        return idKhuPho;
    }

    public void setIdKhuPho(String idKhuPho) {
        this.idKhuPho = idKhuPho;
    }

    public String getTenKhuPho() {
        return tenKhuPho;
    }

    public void setTenKhuPho(String tenKhuPho) {
        this.tenKhuPho = tenKhuPho;
    }

    

    @Override
    public String toString() {
        return "KhuPho [idKhuPho=" + idKhuPho + ", tenKhuPho=" + tenKhuPho + "]";
    }

    
    
}
