/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author dohung
 */
public class HeSoLuongDTO {
    private String MaHSL;
    private double HeSoLuong;

    public HeSoLuongDTO() {
    }

    public HeSoLuongDTO(String MaHSL, double HeSoLuong) {
        this.MaHSL = MaHSL;
        this.HeSoLuong = HeSoLuong;
    }

    public String getMaHSL() {
        return MaHSL;
    }

    public void setMaHSL(String MaHSL) {
        this.MaHSL = MaHSL;
    }

    public double getHeSoLuong() {
        return HeSoLuong;
    }

    public void setHeSoLuong(double HeSoLuong) {
        this.HeSoLuong = HeSoLuong;
    }       
}
