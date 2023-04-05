/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LuongDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author chicu
 */
public class LuongDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public LuongDAO() {
    }

    public ArrayList<LuongDTO> getLuong() {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM luong");
            ArrayList<LuongDTO> luong = new ArrayList();
            rs = stmt.executeQuery();

            while (rs.next()) {
                luong.add(new LuongDTO(rs.getString("MaLuong"), rs.getDouble("LuongCB")));
            }
            return luong;
        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt, rs);
        }
    }

    public boolean addLuong(LuongDTO luong) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "INSERT INTO luong (MaLuong, MaNV) VALUES (?, ?)");
            stmt.setString(1, luong.getMaLuong());
            stmt.setDouble(2, luong.getLuongCoBan());
            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public boolean deleteLuong(LuongDTO luong) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "DELETE FROM luong WHERE MaLuong = ?");
            stmt.setString(1, luong.getMaLuong());
            stmt.setDouble(2, luong.getLuongCoBan());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public boolean updateLuong(LuongDTO luong) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "UPDATE luong SET TienLuong = ? WHERE MaLuong = ?");
            stmt.setDouble(1, luong.getLuongCoBan());
            stmt.setString(2, luong.getMaLuong());
            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }
}
