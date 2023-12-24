package model.entity;

public class BienLai {
    private KhachHang khachHang;
    private double chiSoDienCu;
    private double chiSoDienMoi;
    private double tien;

    public BienLai(KhachHang khachHang, double chiSoDienCu, double chiSoDienMoi) {
        this.khachHang = khachHang;
        this.chiSoDienCu = chiSoDienCu;
        this.chiSoDienMoi = chiSoDienMoi;
        this.tien = (this.chiSoDienMoi - this.chiSoDienCu)*5;
    }

    public BienLai() {
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public double getChiSoDienCu() {
        return chiSoDienCu;
    }

    public void setChiSoDienCu(double chiSoDienCu) {
        this.chiSoDienCu = chiSoDienCu;
    }

    public double getChiSoDienMoi() {
        return chiSoDienMoi;
    }

    public void setChiSoDienMoi(double chiSoDienMoi) {
        this.chiSoDienMoi = chiSoDienMoi;
    }

    public double getTien() {
        return tien;
    }

    public void setTien(double tien) {
        this.tien = tien;
    }

    @Override
    public String toString() {
        return "BienLai [khachHang=" + khachHang.toString() + ", chiSoDienCu=" + chiSoDienCu + ", chiSoDienMoi=" + chiSoDienMoi
                + ", tien=" + tien + "]";
    }
}
