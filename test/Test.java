
import BUS.ChucVuBUS;
import DTO.ChucVuDTO;
import DTO.NhanVienDTO;
import Excel.NhanVienExcel;
import Exception.DuplicatedException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dohung
 */
public class Test {

    public static void checkDAO() {
        try {
            ChucVuBUS chucvudao = new ChucVuBUS();
            ChucVuDTO chucvudto = new ChucVuDTO("001", "Giam doc", "Lienhung");
            boolean add = chucvudao.addChucVu(chucvudto);
            System.out.println(add);
            ChucVuDTO updatedto = new ChucVuDTO();
            updatedto.setMaCV("001");
            updatedto.setGhiChu("LienHung12");
            updatedto.setTenCV("GiamDoc212");

            boolean updateChucVu = chucvudao.updateChucVu(updatedto);

            System.out.println(updateChucVu);
            ArrayList<ChucVuDTO> chucvu = chucvudao.getChucVu();

            for (ChucVuDTO a : chucvu) {
                System.out.println(a.getMaCV() + "\t" + a.getTenCV() + "\t" + a.getGhiChu());
            }
        } catch (DuplicatedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void checkImport() {
        try {
            NhanVienExcel excel = new NhanVienExcel();
            excel.importNhanVien("NhanSu.xlsx");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

    public static void checkExport() {
        try {
            NhanVienExcel excel = new NhanVienExcel();
            excel.exportNhanVien("NhanSu.xlsx");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

    public static void main(String[] arg) {
        checkImport();
    }
}
