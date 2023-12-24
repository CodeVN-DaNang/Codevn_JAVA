package bai_4.model;

import java.util.ArrayList;

public class HoGiaDinh {
    //  Số thành viên trong gia đình, Số nhà, thông tin mỗi cá nhân trong gia đình
    private String idHoGiaDinh;
    private String soNha;
    private int soThanhVien;
    private ArrayList<Nguoi> thanhVienGiaDinhList = new ArrayList<>();
    private KhuPho khuPho;

    

    public HoGiaDinh(){}
    
    public HoGiaDinh(String idHoGiaDinh, String soNha, int soThanhVien, ArrayList<Nguoi> thanhVienGiaDinhList, KhuPho khuPho) {
        this.idHoGiaDinh = idHoGiaDinh;
        this.soNha = soNha;
        this.soThanhVien = soThanhVien;
        this.thanhVienGiaDinhList = thanhVienGiaDinhList;
        this.khuPho = khuPho;
    }

    public String getIdHoGiaDinh() {
        return idHoGiaDinh;
    }

    public void setIdHoGiaDinh(String idHoGiaDinh) {
        this.idHoGiaDinh = idHoGiaDinh;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public int getSoThanhVien() {
        return soThanhVien;
    }

    public void setSoThanhVien(int soThanhVien) {
        this.soThanhVien = soThanhVien;
    }

    public ArrayList<Nguoi> getThanhVienGiaDinhList() {
        return thanhVienGiaDinhList;
    }

    public void setThanhVienGiaDinhList(ArrayList<Nguoi> thanhVienGiaDinhList) {
        this.thanhVienGiaDinhList = thanhVienGiaDinhList;
    }

    public KhuPho getKhuPho() {
        return khuPho;
    }

    public void setKhuPho(KhuPho khuPho) {
        this.khuPho = khuPho;
    }

    @Override
    public String toString() {
        return "HoGiaDinh [idHoGiaDinh=" + idHoGiaDinh + ", \nsoNha=" + soNha + ", \nsoThanhVien=" + soThanhVien
                + ", \nthanhVienGiaDinhList=" + thanhVienGiaDinhList.toString() + ", \nkhuPho=" + khuPho.toString() +"]";
    }

    
}
