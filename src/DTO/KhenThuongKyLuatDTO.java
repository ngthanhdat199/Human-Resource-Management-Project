/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author chicu
 */
public class KhenThuongKyLuatDTO {

    private String MaKTKL;
    private double SoTien;
    private Date NgayQuyetDinh;
    private String LoaiQuyetDinh;
    private String NoiDung;
    private Date NgaySuaDoi;

    public KhenThuongKyLuatDTO() {
    }

    public KhenThuongKyLuatDTO(String MaKTKL, double SoTien, Date NgayQuyetDinh, String LoaiQuyetDinh, String NoiDung, Date NgaySuaDoi) {
        this.MaKTKL = MaKTKL;
        this.SoTien = SoTien;
        this.NgayQuyetDinh = NgayQuyetDinh;
        this.LoaiQuyetDinh = LoaiQuyetDinh;
        this.NoiDung = NoiDung;
        this.NgaySuaDoi = NgaySuaDoi;
    }

    public KhenThuongKyLuatDTO(String MaKTKL, double SoTien, Date NgayQuyetDinh, String LoaiQuyetDinh, String NoiDung) {
        this.MaKTKL = MaKTKL;
        this.SoTien = SoTien;
        this.NgayQuyetDinh = NgayQuyetDinh;
        this.LoaiQuyetDinh = LoaiQuyetDinh;
        this.NoiDung = NoiDung;
    }

    public String getMaKTKL() {
        return MaKTKL;
    }

    public void setMaKTKL(String MaKTKL) {
        this.MaKTKL = MaKTKL;
    }

    public double getSoTien() {
        return SoTien;
    }

    public void setSoTien(double SoTien) {
        this.SoTien = SoTien;
    }

    public Date getNgayQuyetDinh() {
        return NgayQuyetDinh;
    }

    public void setNgayQuyetDinh(Date NgayQuyetDinh) {
        this.NgayQuyetDinh = NgayQuyetDinh;
    }

    public String getLoaiQuyetDinh() {
        return LoaiQuyetDinh;
    }

    public void setLoaiQuyetDinh(String LoaiQuyetDinh) {
        this.LoaiQuyetDinh = LoaiQuyetDinh;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public Date getNgaySuaDoi() {
        return NgaySuaDoi;
    }

    public void setNgaySuaDoi(Date NgaySuaDoi) {
        this.NgaySuaDoi = NgaySuaDoi;
    }

    public Object[] getSelection() {
        ArrayList<Boolean> result = new ArrayList();
        result.add(Double.isNaN(this.SoTien));
        result.add(this.LoaiQuyetDinh != null);
        result.add(this.NoiDung != null);

        Object[] result2 = result.toArray();
        return result2;
    }
}
