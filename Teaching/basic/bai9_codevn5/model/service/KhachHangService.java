package model.service;

import java.util.ArrayList;
import java.util.List;

import model.entity.KhachHang;
import model.repository.KhachHangRepository;

public class KhachHangService {
    KhachHangRepository khachhangRepository = new KhachHangRepository();
    // crud
    public ArrayList<KhachHang> getAllKhachHangs(){
        return khachhangRepository.getAllkhachHang();
    }

    public void addNewKhachHang(KhachHang khachhang){
        khachhangRepository.addNewKhachHang(khachhang);
    }

    public void updateKhachHang(KhachHang khachHang){
      khachhangRepository.updateKhachHang(khachHang, null, null, 0);
    }
    public void deleteKhachHang(KhachHang khachhang){
        khachhangRepository.deleteKhachHang(khachhang);
    }
    public List<KhachHang>displayKhachHang(){
        return khachhangRepository.displayKhachHang();
    }
    public KhachHang timKhachHangTheoMa(String houseNumber) {
        for (KhachHang khachHang : khachhangRepository.displayKhachHang()) {
            if (khachHang.getHouseNumber().equals(houseNumber)) {
                return khachHang;
            }
        }
        return null;
    }
}
