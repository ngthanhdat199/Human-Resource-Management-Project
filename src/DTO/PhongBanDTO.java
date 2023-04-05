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
public class PhongBanDTO {

    private String MaPB;
    private String TenPB;
    private String SoDienThoai;

    public PhongBanDTO() {
    }

    public PhongBanDTO(String MaPB, String TenPB, String SoDienThoai) {
        this.MaPB = MaPB;
        this.TenPB = TenPB;
        this.SoDienThoai = SoDienThoai;
    }

    public String getMaPB() {
        return MaPB;
    }

    public void setMaPB(String MaPB) {
        this.MaPB = MaPB;
    }

    public String getTenPB() {
        return TenPB;
    }

    public void setTenPB(String TenPB) {
        this.TenPB = TenPB;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public Object[] getSelection() {
        ArrayList<Boolean> result = new ArrayList();
        result.add(this.TenPB != null);
        result.add(this.SoDienThoai != null);

        Object[] result2 = result.toArray();
        return result2;
    }
}
