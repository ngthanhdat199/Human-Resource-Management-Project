/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author chicu
 */
public class NhanVienDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public static final int INDEX_HINHNV = 0;
    public static final int INDEX_TENNV = 1;
    public static final int INDEX_NGAYSINH = 2;
    public static final int INDEX_GIOITINH = 3;
    public static final int INDEX_DIACHI = 4;
    public static final int INDEX_SOCMND = 5;
    public static final int INDEX_SODIENTHOAI = 6;
    public static final int INDEX_EMAIL = 7;
    public static final int INDEX_MAPB = 8;
    public static final int INDEX_MACV = 9;
    public static final int INDEX_MATDHV = 10;
    public static final int INDEX_MAHSL = 11;

    public NhanVienDAO() {
    }

    public ArrayList<NhanVienDTO> getNhanVien() {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM nhanvien");

            rs = stmt.executeQuery();

            ArrayList<NhanVienDTO> nhanvien = new ArrayList();
            while (rs.next()) {
                nhanvien.add(new NhanVienDTO(
                        rs.getString("MaNV"),
                        rs.getString("HinhNV"),
                        rs.getString("TenNV"),
                        rs.getString("NgaySinh"),
                        rs.getString("GioiTinh"),
                        rs.getString("DiaChi"),
                        rs.getString("SoCMND"),
                        rs.getString("SoDienThoai"),
                        rs.getString("Email"),
                        rs.getString("MaPB"),
                        rs.getString("MaCV"),
                        rs.getString("MaTDHV"),
                        rs.getString("MaHSL"))
                );
            }
            return nhanvien;
        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt, rs);
        }
    }

    public NhanVienDTO findNhanVienByID(String id) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM nhanvien WHERE MaNV = ?");
            stmt.setString(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                NhanVienDTO nvdto = new NhanVienDTO();
                nvdto.setMaNV(rs.getString("MaNV"));
                nvdto.setHinhNV(rs.getString("HinhNV"));
                nvdto.setTenNV(rs.getString("TenNV"));
                nvdto.setNgaySinh(rs.getString("NgaySinh"));
                nvdto.setGioiTinh(rs.getString("GioiTinh"));
                nvdto.setDiaChi(rs.getString("DiaChi"));
                nvdto.setSoCMND(rs.getString("SoCMND"));
                nvdto.setSoDienThoai(rs.getString("SoDienThoai"));
                nvdto.setEmail(rs.getString("Email"));
                nvdto.setMaPB(rs.getString("MaPB"));
                nvdto.setMaCV(rs.getString("MaCV"));
                nvdto.setMaTDHV(rs.getString("MaTDHV"));
                nvdto.setMaHSL(rs.getString("MaHSL"));

                return nvdto;
            }

        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt, rs);
        }
        return null;
    }

    public ArrayList<NhanVienDTO> findNhanVienByFilter(NhanVienDTO nhanvien) {
        try {
            String table = "";
            Object[] selection = nhanvien.getSelection();
            for (int i = 0; i < selection.length; i++) {
                if ((boolean) selection[i]) {
                    switch (i) {
                        case INDEX_HINHNV ->
                            table += "HinhNV = ? and ";
                        case INDEX_TENNV ->
                            table += "TenNV = ? and ";
                        case INDEX_NGAYSINH ->
                            table += "NgaySinh = ? and ";
                        case INDEX_GIOITINH ->
                            table += "GioiTinh = ? and ";
                        case INDEX_DIACHI ->
                            table += "DiaChi = ? and ";
                        case INDEX_SOCMND ->
                            table += "SoCMND = ? and ";
                        case INDEX_SODIENTHOAI ->
                            table += "SoDienThoai = ? and ";
                        case INDEX_EMAIL ->
                            table += "Email = ? and ";
                        case INDEX_MAPB ->
                            table += "MaPB = ? and ";
                        case INDEX_MACV ->
                            table += "MaCV = ? and ";
                        case INDEX_MATDHV ->
                            table += "MaTDHV = ? and ";
                        case INDEX_MAHSL ->
                            table += "MaHSL = ? and ";
                    }
                }
            }
            table = table.substring(0, table.length() - 4);

            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM nhanvien WHERE " + table);
            int index = 1;
            for (int i = 0; i < selection.length; i++) {
                if ((boolean) selection[i]) {
                    switch (i) {
                        case INDEX_HINHNV ->
                            stmt.setString(index++, nhanvien.getHinhNV());
                        case INDEX_TENNV ->
                            stmt.setString(index++, nhanvien.getTenNV());
                        case INDEX_NGAYSINH ->
                            stmt.setString(index++, nhanvien.getNgaySinh());
                        case INDEX_GIOITINH ->
                            stmt.setString(index++, nhanvien.getGioiTinh());
                        case INDEX_DIACHI ->
                            stmt.setString(index++, nhanvien.getDiaChi());
                        case INDEX_SOCMND ->
                            stmt.setString(index++, nhanvien.getSoCMND());
                        case INDEX_SODIENTHOAI ->
                            stmt.setString(index++, nhanvien.getSoDienThoai());
                        case INDEX_EMAIL ->
                            stmt.setString(index++, nhanvien.getEmail());
                        case INDEX_MAPB ->
                            stmt.setString(index++, nhanvien.getMaPB());
                        case INDEX_MACV ->
                            stmt.setString(index++, nhanvien.getMaCV());
                        case INDEX_MATDHV ->
                            stmt.setString(index++, nhanvien.getMaTDHV());
                        case INDEX_MAHSL ->
                            stmt.setString(index++, nhanvien.getMaHSL());
                    }
                }
            }

            rs = stmt.executeQuery();

            ArrayList<NhanVienDTO> list = new ArrayList();
            while (rs.next()) {
                list.add(new NhanVienDTO(
                        rs.getString("MaNV"),
                        rs.getString("HinhNV"),
                        rs.getString("TenNV"),
                        rs.getString("NgaySinh"),
                        rs.getString("GioiTinh"),
                        rs.getString("DiaChi"),
                        rs.getString("SoCMND"),
                        rs.getString("SoDienThoai"),
                        rs.getString("Email"),
                        rs.getString("MaPB"),
                        rs.getString("MaCV"),
                        rs.getString("MaTDHV"),
                        rs.getString("MaHSL"))
                );
            }

            return list;
        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt, rs);
        }
    }

    public ArrayList<NhanVienDTO> findNhanVienByID(NhanVienDTO nhanvien) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM nhanvien WHERE MaNV = ?");
            stmt.setString(1, nhanvien.getMaNV());

            rs = stmt.executeQuery();

            ArrayList<NhanVienDTO> list = new ArrayList();
            while (rs.next()) {
                list.add(new NhanVienDTO(
                        rs.getString("MaNV"),
                        rs.getString("HinhNV"),
                        rs.getString("TenNV"),
                        rs.getString("NgaySinh"),
                        rs.getString("GioiTinh"),
                        rs.getString("DiaChi"),
                        rs.getString("SoCMND"),
                        rs.getString("SoDienThoai"),
                        rs.getString("Email"),
                        rs.getString("MaPB"),
                        rs.getString("MaCV"),
                        rs.getString("MaTDHV"),
                        rs.getString("MaHSL"))
                );
            }

            return list;
        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt, rs);
        }
    }

    public ArrayList<NhanVienDTO> findNhanVienByName(String TenNV) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM `nhanvien` WHERE TenNV LIKE ?");
            stmt.setString(1, "%" + TenNV + "%");

            rs = stmt.executeQuery();
            ArrayList<NhanVienDTO> list = new ArrayList();

            while (rs.next()) {
                list.add(new NhanVienDTO(
                        rs.getString("MaNV"),
                        rs.getString("HinhNV"),
                        rs.getString("TenNV"),
                        rs.getString("NgaySinh"),
                        rs.getString("GioiTinh"),
                        rs.getString("DiaChi"),
                        rs.getString("SoCMND"),
                        rs.getString("SoDienThoai"),
                        rs.getString("Email"),
                        rs.getString("MaPB"),
                        rs.getString("MaCV"),
                        rs.getString("MaTDHV"),
                        rs.getString("MaHSL"))
                );
            }

            return list;

        } catch (SQLException e) {
            return null;
        } finally {
            DBConnection.closeConnection(conn, stmt, rs);
        }
    }

    public boolean addNhanVien(NhanVienDTO nhanvien) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "INSERT INTO nhanvien (MaNV, HinhNV, TenNV, NgaySinh, GioiTinh, DiaChi, SoCMND, SoDienThoai, Email, MaPB, MaCV, MaTDHV) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, nhanvien.getMaNV());
            stmt.setString(2, nhanvien.getHinhNV());
            stmt.setString(3, nhanvien.getTenNV());
            stmt.setString(4, nhanvien.getNgaySinh());
            stmt.setString(5, nhanvien.getGioiTinh());
            stmt.setString(6, nhanvien.getDiaChi());
            stmt.setString(7, nhanvien.getSoCMND());
            stmt.setString(8, nhanvien.getSoDienThoai());
            stmt.setString(9, nhanvien.getEmail());
            stmt.setString(10, nhanvien.getMaPB());
            stmt.setString(11, nhanvien.getMaCV());
            stmt.setString(12, nhanvien.getMaTDHV());
            stmt.setString(13, nhanvien.getMaHSL());
            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public boolean deleteNhanVien(String id) {
        try {
            conn = DBConnection.getConnection();
            deleteChiTietKTKLatMaNV(id  );
            stmt = conn.prepareStatement(
                    "DELETE FROM nhanvien WHERE MaNV = ?");
            stmt.setString(1, id);

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public boolean deleteNhanVien(NhanVienDTO nhanvien) {
        try {
            conn = DBConnection.getConnection();
            deleteChiTietKTKLatMaNV(nhanvien.getMaNV());
            stmt = conn.prepareStatement(
                    "DELETE FROM nhanvien WHERE MaNV = ?");
            stmt.setString(1, nhanvien.getMaNV());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
    }

    public boolean updateNhanVien(NhanVienDTO nhanvien) {
        try {
            Object[] selection = nhanvien.getSelection();
            String table = "";
            for (int i = 0; i < selection.length; i++) {
                if ((boolean) selection[i]) {
                    switch (i) {
                        case INDEX_HINHNV ->
                            table += "HinhNV = ? ,";
                        case INDEX_TENNV ->
                            table += "TenNV = ? ,";
                        case INDEX_NGAYSINH ->
                            table += "NgaySinh = ? ,";
                        case INDEX_GIOITINH ->
                            table += "GioiTinh = ? ,";
                        case INDEX_DIACHI ->
                            table += "DiaChi = ? ,";
                        case INDEX_SOCMND ->
                            table += "SoCMND = ? ,";
                        case INDEX_SODIENTHOAI ->
                            table += "SoDienThoai = ? ,";
                        case INDEX_EMAIL ->
                            table += "Email = ? ,";
                        case INDEX_MAPB ->
                            table += "MaPB = ? ,";
                        case INDEX_MACV ->
                            table += "MaCV = ? ,";
                        case INDEX_MATDHV ->
                            table += "MaTDHV = ? ,";
                        case INDEX_MAHSL ->
                            table += "MaHSL = ? ,";
                    }
                }
            }
            table = table.substring(0, table.length() - 1);

            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(
                    "UPDATE nhanvien SET " + table + "WHERE MaNV = ?");

            int index = 1;
            for (int i = 0; i < selection.length; i++) {
                if ((boolean) selection[i]) {
                    switch (i) {
                        case INDEX_HINHNV ->
                            stmt.setString(index++, nhanvien.getHinhNV());
                        case INDEX_TENNV ->
                            stmt.setString(index++, nhanvien.getTenNV());
                        case INDEX_NGAYSINH ->
                            stmt.setString(index++, nhanvien.getNgaySinh());
                        case INDEX_GIOITINH ->
                            stmt.setString(index++, nhanvien.getGioiTinh());
                        case INDEX_DIACHI ->
                            stmt.setString(index++, nhanvien.getDiaChi());
                        case INDEX_SOCMND ->
                            stmt.setString(index++, nhanvien.getSoCMND());
                        case INDEX_SODIENTHOAI ->
                            stmt.setString(index++, nhanvien.getSoDienThoai());
                        case INDEX_EMAIL ->
                            stmt.setString(index++, nhanvien.getEmail());
                        case INDEX_MAPB ->
                            stmt.setString(index++, nhanvien.getMaPB());
                        case INDEX_MACV ->
                            stmt.setString(index++, nhanvien.getMaCV());
                        case INDEX_MATDHV ->
                            stmt.setString(index++, nhanvien.getMaTDHV());
                        case INDEX_MAHSL ->
                            stmt.setString(index++, nhanvien.getMaHSL());
                    }
                }
            }

            stmt.setString(index, nhanvien.getMaNV());
            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(conn, stmt);
        }
        return false;
    }

    private boolean deleteChiTietKTKLatMaNV(String MaNV) throws SQLException {
        stmt = conn.prepareStatement(
                "DELETE FROM chitietktkl WHERE MaNV = ?");
        stmt.setString(1, MaNV);
        stmt.executeUpdate();
        return true;
    }
}
