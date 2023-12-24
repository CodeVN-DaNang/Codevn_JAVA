package bai_4.model;

public class Nguoi {
    //Họ tên, Tuổi, Nghề nghiệp, số chứng minh nhân dân(duy nhất cho mỗi người)
    private String idNguoi;
    private String tenNguoi;
    private String tuoiNguoi;
    private String ngheNghiep;
    private String cmnd;

    public Nguoi(){}

    public Nguoi(String idNguoi, String tenNguoi, String tuoiNguoi, String ngheNghiep, String cmnd) {
        this.idNguoi = idNguoi;
        this.tenNguoi = tenNguoi;
        this.tuoiNguoi = tuoiNguoi;
        this.ngheNghiep = ngheNghiep;
        this.cmnd = cmnd;
    }

    public String getIdNguoi() {
        return idNguoi;
    }

    public void setIdNguoi(String idNguoi) {
        this.idNguoi = idNguoi;
    }

    public String getTenNguoi() {
        return tenNguoi;
    }

    public void setTenNguoi(String tenNguoi) {
        this.tenNguoi = tenNguoi;
    }

    public String getTuoiNguoi() {
        return tuoiNguoi;
    }

    public void setTuoiNguoi(String tuoiNguoi) {
        this.tuoiNguoi = tuoiNguoi;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    @Override
    public String toString() {
        return "Nguoi [idNguoi=" + idNguoi + ", tenNguoi=" + tenNguoi + ", tuoiNguoi=" + tuoiNguoi + ", ngheNghiep="
                + ngheNghiep + ", cmnd=" + cmnd + "]\n";
    }
}
