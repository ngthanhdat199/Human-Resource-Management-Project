/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChucVuDAO;
import DTO.ChucVuDTO;
import Exception.DuplicatedException;
import java.util.ArrayList;

/**
 *
 * @author chicu
 */
public class ChucVuBUS {

    ChucVuDAO chucvudao = new ChucVuDAO();

    public ChucVuBUS() {
    }

    public ArrayList<ChucVuDTO> getChucVu() {
        return chucvudao.getChucVu();
    }

    public boolean addChucVu(ChucVuDTO chucvu) throws DuplicatedException {
        ArrayList<ChucVuDTO> list = chucvudao.getChucVu();

        for (ChucVuDTO item : list) {
            if (item.getMaCV().equals(chucvu.getMaCV())) {
                throw new DuplicatedException("Mã nhân viên bị trùng ");
            }
        }
        return chucvudao.addChucVu(chucvu);
    }
    
    public ChucVuDTO findCVByID(String id){
        return chucvudao.findCVByID(id);
    }
    
    public boolean deleteChucVu(String id) {
        return chucvudao.deleteChucVu(id);
    }

    public boolean deleteChucVu(ChucVuDTO chucvu) {
        return chucvudao.deleteChucVu(chucvu);
    }

    public boolean updateChucVu(ChucVuDTO chucvu) {
        return chucvudao.updateChucVu(chucvu);
    }

}
