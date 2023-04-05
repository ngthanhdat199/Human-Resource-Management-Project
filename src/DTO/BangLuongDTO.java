/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author dohung
 */
public class BangLuongDTO {

    private String MaNV;
    private String MaLuong;
    private String TenNV;
    private Date NgayLapBang;
    private double LuongCoBan;
    private double HeSoLuong;//sửa dc
    private double ThuongPhat;
    private double TienLuong;
    private Date NgaySuaDoi;
    
    public BangLuongDTO() {
        
    }

    public BangLuongDTO(String MaNV, String MaLuong, String TenNV, Date NgayLapBang, double LuongCoBan, double HeSoLuong, double ThuongPhat,
            double TienLuong, Date NgaySuaDoi) {
        this.MaNV = MaNV;
        this.MaLuong = MaLuong;
        this.TenNV = TenNV;
        this.NgayLapBang = NgayLapBang;
        this.LuongCoBan = LuongCoBan;
        this.HeSoLuong = HeSoLuong;
        this.ThuongPhat = ThuongPhat;
        this.TienLuong = TienLuong;
        this.NgaySuaDoi = NgaySuaDoi;
    }

    public BangLuongDTO(String MaNV, String MaLuong, String TenNV, double LuongCoBan,
            double ThuongPhat, double TienLuong) {
        this.MaNV = MaNV;
        this.MaLuong = MaLuong;
        this.TenNV = TenNV;
        this.LuongCoBan = LuongCoBan;
        this.ThuongPhat = ThuongPhat;
        this.TienLuong = TienLuong;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public Date getNgayLapBang() {
        return NgayLapBang;
    }

    public void setNgayLapBang(Date NgayLapBang) {
        this.NgayLapBang = NgayLapBang;
    }

    public double getLuongCoBan() {
        return LuongCoBan;
    }

    public void setLuongCoBan(double LuongCoBan) {
        this.LuongCoBan = LuongCoBan;
    }

    public double getHeSoLuong() {
        return HeSoLuong;
    }

    public void setHeSoLuong(double HeSoLuong) {
        this.HeSoLuong = HeSoLuong;
    }

    public double getThuongPhat() {
        return ThuongPhat;
    }

    public void setThuongPhat(double ThuongPhat) {
        this.ThuongPhat = ThuongPhat;
    }

    public double getTienLuong() {
        return TienLuong;
    }

    public void setTienLuong(double TienLuong) {
        this.TienLuong = TienLuong;
    }

    public String getMaLuong() {
        return MaLuong;
    }

    public void setMaLuong(String MaLuong) {
        this.MaLuong = MaLuong;
    }

    public Date getNgaySuaDoi() {
        return NgaySuaDoi;
    }

    public void setNgaySuaDoi(Date NgaySuaDoi) {
        this.NgaySuaDoi = NgaySuaDoi;
    }

}
