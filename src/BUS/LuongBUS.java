/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LuongDAO;
import DTO.LuongDTO;
import Exception.DuplicatedException;
import java.util.ArrayList;

/**
 *
 * @author chicu
 */
public class LuongBUS {

    LuongDAO luongdao = new LuongDAO();

    public LuongBUS() {
    }

    public ArrayList<LuongDTO> getLuong() {
        return luongdao.getLuong();
    }

    public boolean addLuong(LuongDTO luong) throws DuplicatedException {
        ArrayList<LuongDTO> list = luongdao.getLuong();
        
        for(LuongDTO item : list) {
            if(item.getMaLuong().equals(luong.getMaLuong())) {
                throw new DuplicatedException("Mã lương bị trùng ");
            }
        }
        return luongdao.addLuong(luong);
    }

    public boolean deleteLuong(LuongDTO luong) {
        return luongdao.deleteLuong(luong);
    }

    public boolean updateLuong(LuongDTO luong) {
        return luongdao.updateLuong(luong);
    }

}
