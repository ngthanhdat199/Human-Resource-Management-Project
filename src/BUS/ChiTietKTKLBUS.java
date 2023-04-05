/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietKTKLDAO;
import DTO.ChiTietKTKLDTO;
import Exception.DuplicatedException;
import java.util.ArrayList;

/**
 *
 * @author chicu
 */
public class ChiTietKTKLBUS {

    ChiTietKTKLDAO khenthuongkyluatdao = new ChiTietKTKLDAO();

    public ChiTietKTKLBUS() {
    }

    public ArrayList<ChiTietKTKLDTO> getChiTietKTKL() {
        return khenthuongkyluatdao.getChiTietKTKL();
    }

    public boolean addChiTietKTKL(ChiTietKTKLDTO khenthuongkyluat) throws DuplicatedException {
        ArrayList<ChiTietKTKLDTO> list = khenthuongkyluatdao.getChiTietKTKL();

        for (ChiTietKTKLDTO item : list) {
            if (item.getMaNV().equals(khenthuongkyluat.getMaNV()) && item.getMaKTKL().equals(khenthuongkyluat.getMaKTKL())) {
                throw new DuplicatedException("Mã khen thưởng kỷ luật và mã nhân viên bị trùng ");
            }
        }
        return khenthuongkyluatdao.addChiTietKTKL(khenthuongkyluat);
    }

    public boolean deleteChiTietKTKL(ChiTietKTKLDTO khenthuongkyluat) {
        return khenthuongkyluatdao.deleteChiTietKTKL(khenthuongkyluat);
    }

    public boolean updateChiTietKTKL(ChiTietKTKLDTO khenthuongkyluat) {
        return khenthuongkyluatdao.updateChiTietKTKL(khenthuongkyluat);
    }

}
