/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhenThuongKyLuatDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author chicu
 */
public class KhenThuongKyLuatDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public static final int INDEX_SOTIEN = 0;
    public static final int INDEX_LOAIQUYETDINH = 1;
    public static final int INDEX_NOIDUNG = 2;

    public KhenThuongKyLuatDAO() {
    }

    public ArrayList<KhenThuongKyLuatDTO> getKhenThuongKyLuat() {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM Khenthuongkyluat");
            ArrayList<KhenThuongKyLuatDTO> khenthuongkyluat = new ArrayList();
            rs = stmt.executeQuery();

            while (rs.next()) {
                khenthuongkyluat.add(new KhenThuongKyLuatDTO(
                        rs.getString("MaKTKL"),
                        rs.getDouble("SoTien"),
                        rs.getDate("NgayQuyetDinh"),
                        rs.getString("LoaiQuyetDinh"),
                        rs.getString("NoiDung"),
                        rs.getDate("NgaySuaDoi")
                ));
            }
            return khenthuongkyluat;
        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt, rs);
        }
    }

    public boolean addKhenThuongKyLuat(KhenThuongKyLuatDTO khenthuongkiluat) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "INSERT INTO Khenthuongkyluat (MaKTKL, SoTien, NgayQuyetDinh, LoaiQuyetDinh, NoiDung, NgaySuaDoi) VALUES (?, ?, CURRENT_DATE, ?, ?, CURRENT_DATE)");
            stmt.setString(1, khenthuongkiluat.getMaKTKL());
            stmt.setDouble(2, khenthuongkiluat.getSoTien());
            stmt.setString(3, khenthuongkiluat.getLoaiQuyetDinh());
            stmt.setString(4, khenthuongkiluat.getNoiDung());
            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public boolean deleteKhenThuongKyLuat(String id) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "DELETE FROM Khenthuongkyluat WHERE MaKTKL = ?");
            stmt.setString(1, id);

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public boolean deleteKhenThuongKyLuat(KhenThuongKyLuatDTO khenthuongkiluat) {
        try {
            conn = DBConnection.getConnection();
            deleteChiTietKTKLatMaKTKL(khenthuongkiluat.getMaKTKL());
            stmt = conn.prepareStatement(
                    "DELETE FROM khenthuongkyluat WHERE MaKTKL = ?");
            stmt.setString(1, khenthuongkiluat.getMaKTKL());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public boolean updateKhenThuongKyLuat(KhenThuongKyLuatDTO khenthuongkiluat) {
        try {
            Object[] selection = khenthuongkiluat.getSelection();
            String table = "NgaySuaDoi = CURRENT_DATE, ";
            for (int i = 0; i < selection.length; i++) {
                if ((boolean) selection[i]) {
                    switch (i) {
                        case INDEX_SOTIEN ->
                            table += "SoTien = ? ,";
                        case INDEX_LOAIQUYETDINH ->
                            table += "LoaiQuyetDinh = ? ,";
                        case INDEX_NOIDUNG ->
                            table += "NoiDung = ? ,";
                    }
                }
            }
            table = table.substring(0, table.length() - 1);

            String sql = "UPDATE khenthuongkyluat SET " + table + "WHERE MaKTKL = ? ";

            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);

            int index = 1;
            for (int i = 0; i < selection.length; i++) {
                if ((boolean) selection[i]) {
                    switch (i) {
                        case INDEX_SOTIEN ->
                            stmt.setDouble(index++, khenthuongkiluat.getSoTien());
                        case INDEX_LOAIQUYETDINH ->
                            stmt.setString(index++, khenthuongkiluat.getLoaiQuyetDinh());
                        case INDEX_NOIDUNG ->
                            stmt.setString(index++, khenthuongkiluat.getNoiDung());
                    }
                }
            }

            stmt.setString(index, khenthuongkiluat.getMaKTKL());
            stmt.executeUpdate();

            if (hasBangLuong()) {
                updateLuongAllNhanVien();
            }

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    private boolean hasBangLuong() throws SQLException {
        stmt = conn.prepareStatement("SELECT * FROM khenthuongkyluat JOIN chitietluong "
                + "WHERE MONTH(khenthuongkyluat.NgayQuyetDinh) = MONTH(chitietluong.NgayLapBang) AND YEAR(khenthuongkyluat.NgayQuyetDinh) = YEAR(chitietluong.NgayLapBang) "
                + "AND MONTH(chitietluong.NgayLapBang) = MONTH(CURRENT_DATE) AND YEARchitietluong.NgayLapBang) = YEAR(CURRENT_DATE);");
        rs = stmt.executeQuery();
        return rs.next();
    }

    private ArrayList<String> getMaNhanVien() throws SQLException {
        stmt = conn.prepareStatement(
                "SELECT chitietktkl.MaNV FROM chitietktkl JOIN khenthuongkyluat ON chitietktkl.MaKTKL = khenthuongkyluat.MaKTKL "
                + "WHERE MONTH(khenthuongkyluat.NgaySuaDoi) = MONTH(CURRENT_DATE) AND YEAR(khenthuongkyluat.NgaySuaDoi) = YEAR(CURRENT_DATE)"
                + "AND MONTH(khenthuongkyluat.NgayQuyetDinh) = MONTH(CURRENT_DATE) AND YEAR(khenthuongkyluat.NgayQuyetDinh) = YEAR(CURRENT_DATE);");

        ArrayList<String> MaNhanVien = new ArrayList();
        rs = stmt.executeQuery();

        while (rs.next()) {
            MaNhanVien.add(rs.getString("MaNV"));
        }

        return MaNhanVien;
    }

    private void updateLuongAllNhanVien() throws SQLException {
        String sql = "UPDATE chitietktkl JOIN chitietluong"
                + "	ON chitietktkl.MaNV = chitietluong.MaNV AND MONTH(chitietluong.NgayLapBang) = MONTH(CURRENT_DATE) AND YEAR(chitietluong.NgayLapBang) = YEAR(CURRENT_DATE)"
                + "SET chitietluong.ThuongPhat = (SELECT SUM(khenthuongkyluat.SoTien)"
                + "                    FROM chitietktkl JOIN khenthuongkyluat ON chitietktkl.MaKTKL = khenthuongkyluat.MaKTKL"
                + "                    WHERE chitietktkl.MaNV = ?"
                + "                      AND YEAR(khenthuongkyluat.NgayQuyetDinh) = YEAR(CURRENT_DATE)"
                + "                      AND MONTH(khenthuongkyluat.NgayQuyetDinh) = MONTH(CURRENT_DATE))"
                + "    chitietluong.NgaySuaDoi = CURRENT_DATE"
                + "WHERE chitietktkl.MaNV = ?";
        stmt = conn.prepareStatement(sql);

        ArrayList<String> MaNhanVien = getMaNhanVien();
        for (String ma : MaNhanVien) {
            stmt.setString(1, ma);
            stmt.setString(2, ma);
            stmt.executeUpdate();
        }
    }
    
    public KhenThuongKyLuatDTO findKTKLByID(String MaKTKL) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM Khenthuongkyluat where MaKTKL = ?");
            stmt.setString(1, MaKTKL);

            rs = stmt.executeQuery();

            while (rs.next()) {
                KhenThuongKyLuatDTO ktkldto = new KhenThuongKyLuatDTO();
                ktkldto.setMaKTKL(rs.getString("MaKTKL"));
                ktkldto.setSoTien(rs.getDouble("SoTien"));
                ktkldto.setNgayQuyetDinh(rs.getDate("NgayQuyetDinh"));
                ktkldto.setLoaiQuyetDinh(rs.getString("LoaiQuyetDinh"));
                ktkldto.setNoiDung(rs.getString("NoiDung"));
                ktkldto.setNgaySuaDoi(rs.getDate("NgaySuaDoi"));
                return ktkldto;
            }

        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
    private boolean deleteChiTietKTKLatMaKTKL(String MaKTKL) throws SQLException {
        stmt = conn.prepareStatement(
                "DELETE FROM chitietktkl WHERE MaKTKL = ?");
        stmt.setString(1, MaKTKL);
        stmt.executeUpdate();
        return true;
    }
}
