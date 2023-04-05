/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excel;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author HHH
 */
public class NhanVienExcel extends Excel {

    public static final int COLUMN_INDEX_MANV = 0;
    public static final int COLUMN_INDEX_HINHNV = 1;
    public static final int COLUMN_INDEX_TENNV = 2;
    public static final int COLUMN_INDEX_NGAYSINH = 3;
    public static final int COLUMN_INDEX_GIOITINH = 4;
    public static final int COLUMN_INDEX_DIACHI = 5;
    public static final int COLUMN_INDEX_SOCMND = 6;
    public static final int COLUMN_INDEX_SODIENTHOAI = 7;
    public static final int COLUMN_INDEX_EMAIL = 8;
    public static final int COLUMN_INDEX_MAPB = 9;
    public static final int COLUMN_INDEX_MACV = 10;
    public static final int COLUMN_INDEX_MATDHV = 11;
    public static final int COLUMN_INDEX_MAHSL = 12;

    NhanVienDAO nhanviendao = new NhanVienDAO();

    public boolean importNhanVien(String filepath) throws FileNotFoundException, IOException {

        // Đọc một file XSL.
        FileInputStream inputStream = new FileInputStream(new File(filepath));

        // Đối tượng workbook cho file XSL.
        Workbook workbook = getWorkbook(inputStream, filepath);
        // Lấy ra sheet đầu tiên từ workbook
        Sheet sheet = workbook.getSheetAt(0);

//        FormulaEvaluator formula = workbook.getCreationHelper().createFormulaEvaluator();
        for (Row row : sheet) {
            NhanVienDTO item = new NhanVienDTO();
            boolean isFirstRow = false;
            for (Cell cell : row) {
                if (cell.getRowIndex() == 0) {
                    isFirstRow = true;
                    break;
                }
                switch (cell.getColumnIndex()) {
                    case COLUMN_INDEX_MANV ->
                        item.setMaNV(cell.getStringCellValue());
                    case COLUMN_INDEX_HINHNV ->
                        item.setHinhNV(cell.getStringCellValue());
                    case COLUMN_INDEX_TENNV ->
                        item.setTenNV(cell.getStringCellValue());
                    case COLUMN_INDEX_NGAYSINH ->
                        item.setNgaySinh(cell.getStringCellValue());
                    case COLUMN_INDEX_GIOITINH ->
                        item.setGioiTinh(cell.getStringCellValue());
                    case COLUMN_INDEX_DIACHI ->
                        item.setDiaChi(cell.getStringCellValue());
                    case COLUMN_INDEX_SOCMND ->
                        item.setSoCMND(cell.getStringCellValue());
                    case COLUMN_INDEX_SODIENTHOAI ->
                        item.setSoDienThoai(cell.getStringCellValue());
                    case COLUMN_INDEX_EMAIL ->
                        item.setEmail(cell.getStringCellValue());
                    case COLUMN_INDEX_MAPB ->
                        item.setMaPB(cell.getStringCellValue());
                    case COLUMN_INDEX_MACV ->
                        item.setMaCV(cell.getStringCellValue());
                    case COLUMN_INDEX_MATDHV ->
                        item.setMaTDHV(cell.getStringCellValue());
                    case COLUMN_INDEX_MAHSL ->
                        item.setMaHSL(cell.getStringCellValue());
                }
            }
            if (!isFirstRow && !"".equals(item.getMaNV())) {
                nhanviendao.addNhanVien(item);
            }
        }
        workbook.close();
        inputStream.close();

        return true;
    }

    public boolean exportNhanVien(String filepath) throws FileNotFoundException, IOException {
        FileOutputStream outputStream = new FileOutputStream(new File(filepath));
        Workbook workbook = getWorkbook(filepath);

        Sheet sheet = workbook.createSheet("NhanVien");

        ArrayList<NhanVienDTO> nhanvien = nhanviendao.getNhanVien();
        int rowIndex = 0;

        writeHeader(sheet, rowIndex);
        rowIndex++;

        for (NhanVienDTO item : nhanvien) {
            Row row = sheet.createRow(rowIndex);
            writeData(item, row);
            rowIndex++;
        }

        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        return true;
    }

    @Override
    protected void writeHeader(Sheet sheet, int rowIndex) {
        // Create row
        Row row = sheet.createRow(rowIndex);

        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_MANV);
        cell.setCellValue("Mã nhân viên");

        cell = row.createCell(COLUMN_INDEX_HINHNV);
        cell.setCellValue("Hình nhân viên");

        cell = row.createCell(COLUMN_INDEX_TENNV);
        cell.setCellValue("Tên nhân viên");

        cell = row.createCell(COLUMN_INDEX_NGAYSINH);
        cell.setCellValue("Ngày sinh");

        cell = row.createCell(COLUMN_INDEX_GIOITINH);
        cell.setCellValue("Giới tính");

        cell = row.createCell(COLUMN_INDEX_DIACHI);
        cell.setCellValue("Địa chỉ");

        cell = row.createCell(COLUMN_INDEX_SOCMND);
        cell.setCellValue("Số CMND");

        cell = row.createCell(COLUMN_INDEX_SODIENTHOAI);
        cell.setCellValue("Số điện thoại");

        cell = row.createCell(COLUMN_INDEX_EMAIL);
        cell.setCellValue("Email");

        cell = row.createCell(COLUMN_INDEX_MAPB);
        cell.setCellValue("Mã phòng ban");

        cell = row.createCell(COLUMN_INDEX_MACV);
        cell.setCellValue("Mã chức vụ");

        cell = row.createCell(COLUMN_INDEX_MATDHV);
        cell.setCellValue("Mã TDHV");
        
        cell = row.createCell(COLUMN_INDEX_MAHSL);
        cell.setCellValue("Mã HSL");
    }

    protected void writeData(NhanVienDTO item, Row row) {
        Cell cell = row.createCell(COLUMN_INDEX_MANV);
        cell.setCellValue(item.getMaNV());

        cell = row.createCell(COLUMN_INDEX_HINHNV);
        cell.setCellValue(item.getHinhNV());

        cell = row.createCell(COLUMN_INDEX_TENNV);
        cell.setCellValue(item.getTenNV());

        cell = row.createCell(COLUMN_INDEX_NGAYSINH);
        cell.setCellValue(item.getNgaySinh());

        cell = row.createCell(COLUMN_INDEX_GIOITINH);
        cell.setCellValue(item.getGioiTinh());

        cell = row.createCell(COLUMN_INDEX_DIACHI);
        cell.setCellValue(item.getDiaChi());

        cell = row.createCell(COLUMN_INDEX_SOCMND);
        cell.setCellValue(item.getSoCMND());

        cell = row.createCell(COLUMN_INDEX_SODIENTHOAI);
        cell.setCellValue(item.getSoDienThoai());

        cell = row.createCell(COLUMN_INDEX_EMAIL);
        cell.setCellValue(item.getEmail());
        
        cell = row.createCell(COLUMN_INDEX_MAPB);
        cell.setCellValue(item.getMaPB());

        cell = row.createCell(COLUMN_INDEX_MACV);
        cell.setCellValue(item.getMaCV());

        cell = row.createCell(COLUMN_INDEX_MATDHV);
        cell.setCellValue(item.getMaTDHV());
        
        cell = row.createCell(COLUMN_INDEX_MAHSL);
        cell.setCellValue(item.getMaHSL());
    }
}
