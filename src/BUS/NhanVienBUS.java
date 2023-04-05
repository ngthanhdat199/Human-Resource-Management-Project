/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import Exception.DuplicatedException;
import java.util.ArrayList;

/**
 *
 * @author chicu
 */
public class NhanVienBUS {
    NhanVienDAO NhanViendao = new NhanVienDAO();
    
    public NhanVienBUS() {
    }
    
    public ArrayList<NhanVienDTO> getNhanVien() {
        return NhanViendao.getNhanVien();
    }

    //Tìm kiếm
    public ArrayList<NhanVienDTO> findNhanVienByFilter(NhanVienDTO data) {
        return NhanViendao.findNhanVienByFilter(data);

    }
    
    public boolean addNhanVien(NhanVienDTO NhanVien) throws DuplicatedException {
        ArrayList<NhanVienDTO> list = NhanViendao.getNhanVien();
        
        for(NhanVienDTO item : list) {
            if(item.getMaNV().equals(NhanVien.getMaNV())) {
                throw new DuplicatedException("Mã nhân viên bị trùng ");
            }
        }
        return NhanViendao.addNhanVien(NhanVien);
    }
    
    public boolean deleteNhanVien(String id) {
        return NhanViendao.deleteNhanVien(id);
    }
    
    public boolean deleteNhanVien(NhanVienDTO NhanVien) {
        return NhanViendao.deleteNhanVien(NhanVien);
    }
    
    public boolean updateNhanVien(NhanVienDTO NhanVien) {
        return NhanViendao.updateNhanVien(NhanVien);
    }
    
    public NhanVienDTO getNhanVienByID(String MaNV){
        return NhanViendao.findNhanVienByID(MaNV);
    }
    
    public ArrayList<NhanVienDTO> getNhanVienByName(String TenNV) {
        return  NhanViendao.findNhanVienByName(TenNV);
    }
}
