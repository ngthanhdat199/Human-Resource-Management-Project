/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.BangLuongDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chicu
 */
public class BangLuongDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public BangLuongDAO() {
    }

    public ArrayList<BangLuongDTO> getBangLuong() {
        try {
            conn = DBConnection.getConnection();
            String sql
                    = "SELECT nhanvien.MaNV,chitietluong.MaLuong, nhanvien.TenNV,chitietluong.NgayLapBang,luong.LuongCB,chitietluong.HeSoLuong, chitietluong.ThuongPhat, chitietluong.                            HeSoLuong * luong.LuongCB + chitietluong.ThuongPhat as 'TienLuong', chitietluong.NgaySuaDoi "
                    + "FROM NhanVien JOIN chitietluong JOIN luong ON nhanvien.MaNV = chitietluong.MaNV AND chitietluong.MaLuong = luong.MaLuong ";

            stmt = conn.prepareStatement(sql);
            ArrayList<BangLuongDTO> bangluong = new ArrayList();
            rs = stmt.executeQuery();

            while (rs.next()) {
                bangluong.add(new BangLuongDTO(
                        rs.getString("MaNV"),
                        rs.getString("MaLuong"),
                        rs.getString("TenNV"),
                        rs.getDate("NgayLapBang"),
                        rs.getDouble("LuongCB"),
                        rs.getDouble("HeSoLuong"),
                        rs.getDouble("ThuongPhat"),
                        rs.getDouble("TienLuong"),
                        rs.getDate("NgaySuaDoi")
                ));
            }
            return bangluong;
        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt, rs);
        }
    }

    public boolean addBangLuong(BangLuongDTO bangluong) {
        try {
            conn = DBConnection.getConnection();
            String sql
                    = "INSERT INTO `chitietluong`(`MaLuong`, `MaNV`, `ThuongPhat`, `HeSoLuong`, `NgayLapBang`, `NgaySuaDoi`) "
                    + "VALUES ('?,?,"
                    + "(SELECT SUM(khenthuongkyluat.SoTien) "
                    + "FROM chitietktkl JOIN khenthuongkyluat ONchitietktkl.MaKTKL = khenthuongkyluat.MaKTKL "
                    + "WHERE chitietktkl.MaNV = ? AND YEAR(khenthuongkyluat.NgayQuyetDinh) = YEAR(CURRENT_DATE) AND MONTH(khenthuongkyluat.NgayQuyetDinh) = MONTH(CURRENT_DATE)),"
                    + "(SELECT hesoluong.HeSoLuong "
                    + "FROM hesoluong JOIN nhanvien ON hesoluong.MaHSL = nhanvien.MaHSL AND nhanvien.MaNV = ?)"
                    + ",CURRENT_DATE, CURRENT_DATE);";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, bangluong.getMaLuong());
            stmt.setString(2, bangluong.getMaNV());
            stmt.setString(3, bangluong.getMaNV());
            stmt.setString(4, bangluong.getMaNV());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public Hashtable getThongKePhongBan(String MaPB) {
        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT nhanvien.MaPB, SUM(chitietluong.HeSoLuong * luong.LuongCB + chitietluong.ThuongPhat) AS 'TienLuong'\n" +
                         "FROM nhanvien JOIN chitietluong JOIN luong ON nhanvien.MaNV = chitietluong.MaNV AND chitietluong.MaLuong = luong.MaLuong\n" +
                                            "AND YEAR(chitietluong.NgayLapBang) = YEAR(CURRENT_DATE)\n" +
                         "WHERE nhanvien.MaPB = ?\n" +
                         "GROUP BY nhanvien.MaPB;";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, MaPB);

            rs = stmt.executeQuery();
            
            Hashtable thongke = new Hashtable();
            
            while(rs.next()) {
                thongke.put(rs.getString("MaPB"), rs.getDouble("TienLuong"));
            }

            return thongke;

        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }
    
    public Hashtable getThongKeThang(int month) {
        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT ? as Thang, SUM(chitietluong.HeSoLuong * luong.LuongCB + chitietluong.ThuongPhat) AS 'TienLuong'\n" +
                         "FROM nhanvien JOIN chitietluong JOIN luong ON nhanvien.MaNV = chitietluong.MaNV AND chitietluong.MaLuong = luong.MaLuong\n" +
                                            "AND YEAR(chitietluong.NgayLapBang) = YEAR(CURRENT_DATE) AND MONTH(chitietluong.NgayLapBang) = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, month);
            stmt.setInt(2, month);

            rs = stmt.executeQuery();
            
            Hashtable thongke = new Hashtable();
            
            while(rs.next()) {
                thongke.put(rs.getString("Thang"), rs.getDouble("TienLuong"));
            }

            return thongke;

        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }
    
    public Hashtable getThongKeNam() {
        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT MONTH(chitietluong.NgayLapBang) as Thang, SUM(chitietluong.HeSoLuong * luong.LuongCB + chitietluong.ThuongPhat) AS 'TienLuong'\n" +
                         "FROM nhanvien JOIN chitietluong JOIN luong ON nhanvien.MaNV = chitietluong.MaNV AND chitietluong.MaLuong = luong.MaLuong\n" +
                                            "AND YEAR(chitietluong.NgayLapBang) = YEAR(CURRENT_DATE)\n" + 
                         "ORDER BY MONTH(chitietluong.NgayLapBang)";

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            
            Hashtable thongke = new Hashtable();
            
            while(rs.next()) {
                thongke.put(rs.getString("Thang"), rs.getDouble("TienLuong"));
            }

            return thongke;

        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }
}
