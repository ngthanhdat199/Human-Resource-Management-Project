/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author chicu
 */
public class ChiTietKTKLDTO {

    private String MaKTKL;
    private String MaNV;

    public ChiTietKTKLDTO() {
    }

    public ChiTietKTKLDTO(String MaKTKL, String MaNV) {
        this.MaKTKL = MaKTKL;
        this.MaNV = MaNV;
    }

    public String getMaKTKL() {
        return MaKTKL;
    }

    public void setMaKTKL(String MaKTKL) {
        this.MaKTKL = MaKTKL;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Object[] getSelection() {
        ArrayList<Boolean> result = new ArrayList();

        Object[] result2 = result.toArray();
        return result2;
    }

}
