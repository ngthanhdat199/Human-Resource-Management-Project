/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhongBanDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author chicu
 */
public class PhongBanDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public static final int INDEX_TENPB = 0;
    public static final int INDEX_SODIENTHOAI = 1;

    public PhongBanDAO() {
    }

    public ArrayList<PhongBanDTO> getPhongBan() {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM phongban");
            ArrayList<PhongBanDTO> phongbanDAO = new ArrayList();

            rs = stmt.executeQuery();
            while (rs.next()) {
                phongbanDAO.add(new PhongBanDTO(rs.getString("MaPB"), rs.getString("TenPB"), rs.getString("SoDienThoai")));
            }
            return phongbanDAO;
        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt, rs);
        }
    }
    
    public PhongBanDTO findPBByID(String id) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM phongban WHERE MaPB = ?");
            stmt.setString(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                PhongBanDTO pbdto = new PhongBanDTO();
                pbdto.setMaPB(rs.getString("MaPB"));
                pbdto.setTenPB(rs.getString("TenPB"));
                pbdto.setSoDienThoai(rs.getString("SoDienThoai"));
                return pbdto;
            }
            
        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt, rs);
        }
        return null;
    }

    public boolean addPhongBan(PhongBanDTO phongban) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "INSERT INTO PhongBan (MaPB, TenPB, SoDienThoai) VALUES (?, ?, ?)");
            stmt.setString(1, phongban.getMaPB());
            stmt.setString(2, phongban.getTenPB());
            stmt.setString(3, phongban.getSoDienThoai());
            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public boolean deletePhongBan(String id) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "DELETE FROM PhongBan WHERE MaPB = ?");
            stmt.setString(1, id);

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public boolean deletePhongBan(PhongBanDTO phongban) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "DELETE FROM PhongBan WHERE MaPB = ?");
            stmt.setString(1, phongban.getMaPB());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public boolean updatePhongBan(PhongBanDTO phongban) {
        try {
            Object[] selection = phongban.getSelection();

            String table = "";
            for (int i = 0; i < selection.length; i++) {
                if ((boolean) selection[i]) {
                    switch (i) {
                        case INDEX_TENPB ->
                            table += "TenPB = ? ,";
                        case INDEX_SODIENTHOAI ->
                            table += "SoDienThoai = ? ,";
                    }
                }
            }
            table = table.substring(0, table.length() - 1);

            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "UPDATE PhongBan SET " + table + "WHERE MaPB = ?");

            int index = 1;
            for (int i = 0; i < selection.length; i++) {
                if ((boolean) selection[i]) {
                    switch (i) {
                        case INDEX_TENPB ->
                            stmt.setString(index++, phongban.getTenPB());
                        case INDEX_SODIENTHOAI ->
                            stmt.setString(index++, phongban.getSoDienThoai());
                    }
                }
            }

            stmt.setString(index, phongban.getMaPB());
            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

}
