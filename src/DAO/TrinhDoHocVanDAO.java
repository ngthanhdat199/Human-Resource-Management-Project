/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TrinhDoHocVanDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author chicu
 */
public class TrinhDoHocVanDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public TrinhDoHocVanDAO() {
    }

    public ArrayList<TrinhDoHocVanDTO> getTrinhDoHocVan() {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM trinhdohv");
            ArrayList<TrinhDoHocVanDTO> trinhdohocvan = new ArrayList();
            rs = stmt.executeQuery();

            while (rs.next()) {
                trinhdohocvan.add(new TrinhDoHocVanDTO(rs.getString("MaTDHV"), rs.getString("TenTDHV")));
            }
            return trinhdohocvan;
        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt, rs);
        }
    }

    public TrinhDoHocVanDTO findTDHVByID(String id) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM trinhdohv WHERE MaTDHV = ?");
            stmt.setString(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                TrinhDoHocVanDTO tdhvdto = new TrinhDoHocVanDTO();
                tdhvdto.setMaTDHV(rs.getString("MaTDHV"));
                tdhvdto.setTenTDHV(rs.getString("TenTDHV"));

                return tdhvdto;
            }

        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt, rs);
        }
        return null;
    }

    public boolean addTrinhDoHocVan(TrinhDoHocVanDTO trinhdohocvan) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "INSERT INTO trinhdohv (MaTDHV, TenTDHV) VALUES (?, ?)");
            stmt.setString(1, trinhdohocvan.getMaTDHV());
            stmt.setString(2, trinhdohocvan.getTenTDHV());
            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public boolean deleteTrinhDoHocVan(String id) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "DELETE FROM trinhdohv WHERE MaTDHV = ?");
            stmt.setString(1, id);

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public boolean deleteTrinhDoHocVan(TrinhDoHocVanDTO trinhdohocvan) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "DELETE FROM trinhdohv WHERE MaTDHV = ?");
            stmt.setString(1, trinhdohocvan.getMaTDHV());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public boolean updateTrinhDoHocVan(TrinhDoHocVanDTO trinhdohocvan) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "UPDATE trinhdohv SET TenTDHV = ? WHERE MaTDHV = ?");

            stmt.setString(1, trinhdohocvan.getTenTDHV());
            stmt.setString(2, trinhdohocvan.getMaTDHV());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }
}
