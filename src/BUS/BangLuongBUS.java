/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.BangLuongDAO;
import DTO.BangLuongDTO;
import Exception.DuplicatedException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author chicu
 */
public class BangLuongBUS {

    BangLuongDAO chitietluongdao = new BangLuongDAO();

    public BangLuongBUS() {
    }

    public ArrayList<BangLuongDTO> getBangLuong() {
        return chitietluongdao.getBangLuong();
    }

    public boolean addBangLuong(BangLuongDTO chitietluong) throws DuplicatedException {
        ArrayList<BangLuongDTO> list = chitietluongdao.getBangLuong();

        for (BangLuongDTO item : list) {
            if (item.getMaLuong().equals(chitietluong.getMaLuong()) && item.getMaNV().equals(chitietluong.getMaNV())) {
                throw new DuplicatedException("Mã lương và mã nhân viên bị trùng");
            }
        }
        return chitietluongdao.addBangLuong(chitietluong);
    }
    
    public Hashtable getThongKePhongBan(String MaPB) {
        return chitietluongdao.getThongKePhongBan(MaPB);
    }
    
    public Hashtable getThongKeThang(int month) {
        return chitietluongdao.getThongKeThang(month);
    }
    
    public Hashtable getThongKeNam() {
        return chitietluongdao.getThongKeNam();
    }  

}
