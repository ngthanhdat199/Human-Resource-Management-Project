/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author chicu
 */
public class NhanVienDTO {

    private String MaNV;
    private String HinhNV;
    private String TenNV;
    private String NgaySinh;
    private String GioiTinh;
    private String DiaChi;
    private String SoCMND;
    private String SoDienThoai;
    private String Email;
    private String MaPB;
    private String MaCV;
    private String MaTDHV;
    private String MaHSL;

    public NhanVienDTO() {
    }

    public NhanVienDTO(String MaNV, String HinhNV, String TenNV, String NgaySinh, String GioiTinh, String DiaChi,
            String SoCMND, String SoDienThoai, String Email, String MaPB, String MaCV, String MaTDHV, String MaHSL) {
        this.MaNV = MaNV;
        this.HinhNV = HinhNV;
        this.TenNV = TenNV;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.SoCMND = SoCMND;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
        this.MaPB = MaPB;
        this.MaCV = MaCV;
        this.MaTDHV = MaTDHV;
        this.MaHSL = MaHSL;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHinhNV() {
        return HinhNV;
    }

    public void setHinhNV(String HinhNV) {
        this.HinhNV = HinhNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public Date getNgaySinhSQL() {
        return Date.valueOf(NgaySinh);
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoCMND() {
        return SoCMND;
    }

    public void setSoCMND(String SoCMND) {
        this.SoCMND = SoCMND;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMaPB() {
        return MaPB;
    }

    public void setMaPB(String MaPB) {
        this.MaPB = MaPB;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

    public String getMaTDHV() {
        return MaTDHV;
    }

    public void setMaTDHV(String MaTDHV) {
        this.MaTDHV = MaTDHV;
    }

    public String getMaHSL() {
        return MaHSL;
    }

    public void setMaHSL(String MaHSL) {
        this.MaHSL = MaHSL;
    }

    public Object[] getSelection() {
        ArrayList<Boolean> result = new ArrayList();
        result.add(this.HinhNV != null);
        result.add(this.TenNV != null);
        result.add(this.NgaySinh != null);
        result.add(this.GioiTinh != null);
        result.add(this.DiaChi != null);
        result.add(this.SoCMND != null);
        result.add(this.SoDienThoai != null);
        result.add(this.Email != null);
        result.add(this.MaPB != null);
        result.add(this.MaCV != null);
        result.add(this.MaTDHV != null);
        result.add(this.MaHSL != null);

        Object[] result2 = result.toArray();
        return result2;
    }
}
