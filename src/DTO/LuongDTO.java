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
public class LuongDTO {

    private String MaLuong;
    private double LuongCoBan;

    public LuongDTO() {
    }

    public LuongDTO(String MaLuong, double LuongCoBan) {
        this.MaLuong = MaLuong;
        this.LuongCoBan = LuongCoBan;
    }


    public String getMaLuong() {
        return MaLuong;
    }

    public void setMaLuong(String MaLuong) {
        this.MaLuong = MaLuong;
    }

    public double getLuongCoBan() {
        return LuongCoBan;
    }

    public void setLuongCoBan(double LuongCoBan) {
        this.LuongCoBan = LuongCoBan;
    }

    public Object[] getSelection() {
        ArrayList<Boolean> result = new ArrayList();

        Object[] result2 = result.toArray();
        return result2;
    }

}
