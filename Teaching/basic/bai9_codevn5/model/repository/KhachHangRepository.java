package model.repository;

import java.util.ArrayList;
import java.util.List;

import model.entity.KhachHang;

public class KhachHangRepository {
   
    ArrayList<KhachHang> khList = new ArrayList<>();

    // crud
    public ArrayList<KhachHang> getAllkhachHang(){
        return khList;
    }

    public void addNewKhachHang(KhachHang khachhang) {
        khList.add(khachhang);
    }

    public void deleteKhachHang(KhachHang khachhang) {
        khList.remove(khachhang );
    }
    public void updateKhachHang(KhachHang khachhang , String names , String houseNumbers, double codes){
        khachhang.setName(names);
        khachhang.setHouseNumber(houseNumbers);
        khachhang.setCode(codes);
    }
   
    public List<KhachHang>displayKhachHang(){
        return khList;
    }
    
}
