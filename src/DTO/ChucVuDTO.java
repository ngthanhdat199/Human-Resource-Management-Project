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
public class ChucVuDTO {

    private String MaCV;
    private String TenCV;
    private String GhiChu;

    public ChucVuDTO() {
    }

    public ChucVuDTO(String MaCV, String TenCV, String GhiChu) {
        this.MaCV = MaCV;
        this.TenCV = TenCV;
        this.GhiChu = GhiChu;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

    public String getTenCV() {
        return TenCV;
    }

    public void setTenCV(String TenCV) {
        this.TenCV = TenCV;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public Object[] getSelection() {
        ArrayList<Boolean> result = new ArrayList();
        result.add(this.TenCV != null);
        result.add(this.GhiChu != null);

        Object[] result2 = result.toArray();
        return result2;
    }

}
