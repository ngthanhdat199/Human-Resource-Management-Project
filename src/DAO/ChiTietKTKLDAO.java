/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietKTKLDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author chicu
 */
public class ChiTietKTKLDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public ChiTietKTKLDAO() {
    }

    public ArrayList<ChiTietKTKLDTO> getChiTietKTKL() {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM chitietktkl");
            ArrayList<ChiTietKTKLDTO> chitietktkl = new ArrayList();
            rs = stmt.executeQuery();

            while (rs.next()) {
                chitietktkl.add(new ChiTietKTKLDTO(rs.getString("MaKTKL"), rs.getString("MaNV")));
            }
            return chitietktkl;
        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt, rs);
        }
    }

    public boolean addChiTietKTKL(ChiTietKTKLDTO chitietktkl) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "INSERT INTO chitietktkl (MaKTKL, MaNV) VALUES (?, ?)");
            stmt.setString(1, chitietktkl.getMaKTKL());
            stmt.setString(2, chitietktkl.getMaNV());
            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public boolean deleteChiTietKTKL(ChiTietKTKLDTO chitietktkl) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "DELETE FROM chitietktkl WHERE MaKTKL = ? AND MaNV = ?");
            stmt.setString(1, chitietktkl.getMaKTKL());
            stmt.setString(2, chitietktkl.getMaNV());

            stmt.executeUpdate();

            if (hasBangLuong()) {
                updateBangLuongNhanVien(chitietktkl.getMaNV());
            }

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public boolean updateChiTietKTKL(ChiTietKTKLDTO chitietktkl) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "UPDATE chitietktkl SET SoTien = ? WHERE MaKTKL = ? AND MaNV = ?");

            stmt.setString(1, chitietktkl.getMaKTKL());
            stmt.setString(2, chitietktkl.getMaNV());
            stmt.executeUpdate();

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

    private void updateBangLuongNhanVien(String MaNV) throws SQLException {
        String sql = "UPDATE chitietktkl JOIN chitietluong"
                + "	ON AND chitietktkl.MaNV = chitietluong.MaNV AND MONTH(chitietluong.NgayLapBang) = MONTH(CURRENT_DATE)"
                + "SET chitietluong.ThuongPhat = (SELECT SUM(khenthuongkyluat.SoTien)"
                + "                    FROM chitietktkl JOIN khenthuongkyluat ON chitietktkl.MaKTKL = khenthuongkyluat.MaKTKL"
                + "                    WHERE chitietktkl.MaNV = ?"
                + "                      AND YEAR(khenthuongkyluat.NgayQuyetDinh) = YEAR(CURRENT_DATE)"
                + "                      AND MONTH(khenthuongkyluat.NgayQuyetDinh) = MONTH(CURRENT_DATE))"
                + "    chitietluong.NgaySuaDoi = CURRENT_DATE"
                + "WHERE chitietktkl.MaNV = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, MaNV);
        stmt.setString(2, MaNV);
        stmt.executeUpdate();
    }
}
