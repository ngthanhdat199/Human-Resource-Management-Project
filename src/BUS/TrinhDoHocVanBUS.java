/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TrinhDoHocVanDAO;
import DTO.TrinhDoHocVanDTO;
import Exception.DuplicatedException;
import java.util.ArrayList;

/**
 *
 * @author chicu
 */
public class TrinhDoHocVanBUS {

    TrinhDoHocVanDAO TrinhDoHocVandao = new TrinhDoHocVanDAO();

    public TrinhDoHocVanBUS() {
    }

    public ArrayList<TrinhDoHocVanDTO> getTrinhDoHocVan() {
        return TrinhDoHocVandao.getTrinhDoHocVan();
    }

    public boolean addTrinhDoHocVan(TrinhDoHocVanDTO TrinhDoHocVan) throws DuplicatedException {
        ArrayList<TrinhDoHocVanDTO> list = TrinhDoHocVandao.getTrinhDoHocVan();

        for (TrinhDoHocVanDTO item : list) {
            if (item.getMaTDHV().equals(TrinhDoHocVan.getMaTDHV())) {
                throw new DuplicatedException("Mã trình độ học vấn bị trùng ");
            }
        }
        return TrinhDoHocVandao.addTrinhDoHocVan(TrinhDoHocVan);
    }

    public TrinhDoHocVanDTO findTDHVByID(String id) {
        return TrinhDoHocVandao.findTDHVByID(id);
    }

    public boolean deleteTrinhDoHocVan(String id) {
        return TrinhDoHocVandao.deleteTrinhDoHocVan(id);
    }

    public boolean deleteTrinhDoHocVan(TrinhDoHocVanDTO TrinhDoHocVan) {
        return TrinhDoHocVandao.deleteTrinhDoHocVan(TrinhDoHocVan);
    }

    public boolean updateTrinhDoHocVan(TrinhDoHocVanDTO TrinhDoHocVan) {
        return TrinhDoHocVandao.updateTrinhDoHocVan(TrinhDoHocVan);
    }
}
