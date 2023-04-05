/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhenThuongKyLuatDAO;
import DTO.KhenThuongKyLuatDTO;
import Exception.DuplicatedException;
import java.util.ArrayList;

/**
 *
 * @author chicu
 */
public class KhenThuongKyLuatBUS {

    KhenThuongKyLuatDAO chitietkhenthuongkyluatdao = new KhenThuongKyLuatDAO();

    public KhenThuongKyLuatBUS() {
    }

    public ArrayList<KhenThuongKyLuatDTO> getKhenThuongKyLuat() {
        return chitietkhenthuongkyluatdao.getKhenThuongKyLuat();
    }

    public boolean addKhenThuongKyLuat(KhenThuongKyLuatDTO chitietkhenthuongkyluat) throws DuplicatedException {
        ArrayList<KhenThuongKyLuatDTO> list = chitietkhenthuongkyluatdao.getKhenThuongKyLuat();

        for (KhenThuongKyLuatDTO item : list) {
            if (item.getMaKTKL().equals(chitietkhenthuongkyluat.getMaKTKL())) {
                throw new DuplicatedException("Mã khen thưởng bị trùng ");
            }
        }
        return chitietkhenthuongkyluatdao.addKhenThuongKyLuat(chitietkhenthuongkyluat);
    }

    public boolean deleteKhenThuongKyLuat(String id) {
        return chitietkhenthuongkyluatdao.deleteKhenThuongKyLuat(id);
    }

    public boolean deleteKhenThuongKyLuat(KhenThuongKyLuatDTO chitietkhenthuongkyluat) {
        return chitietkhenthuongkyluatdao.deleteKhenThuongKyLuat(chitietkhenthuongkyluat);
    }

    public boolean updateKhenThuongKyLuat(KhenThuongKyLuatDTO chitietkhenthuongkyluat) {
        return chitietkhenthuongkyluatdao.updateKhenThuongKyLuat(chitietkhenthuongkyluat);
    }

}
