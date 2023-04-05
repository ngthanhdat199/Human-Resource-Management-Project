/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excel;

import DAO.BangLuongDAO;
import DTO.BangLuongDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author HHH
 */
public class BangLuongExcel extends Excel{
    public static final int COLUMN_INDEX_MANV = 0;
    public static final int COLUMN_INDEX_MALUONG = 1;
    public static final int COLUMN_INDEX_TENNV = 2;
    public static final int COLUMN_INDEX_NGAYLAPBANG = 3;
    public static final int COLUMN_INDEX_LUONGCOBAN = 4;
    public static final int COLUMN_INDEX_HESOLUONG = 5;
    public static final int COLUMN_INDEX_THUONGPHAT = 6;
    public static final int COLUMN_INDEX_TIENLUONG = 7;
    public static final int COLUMN_INDEX_NGAYSUADOI = 8;

    BangLuongDAO bangluongdao = new BangLuongDAO();

    public boolean importBangLuong(String filepath) throws FileNotFoundException, IOException {

        // Đọc một file XSL.
        FileInputStream inputStream = new FileInputStream(new File(filepath));

        // Đối tượng workbook cho file XSL.
        Workbook workbook = getWorkbook(inputStream, filepath);
        // Lấy ra sheet đầu tiên từ workbook
        Sheet sheet = workbook.getSheetAt(0);

//        FormulaEvaluator formula = workbook.getCreationHelper().createFormulaEvaluator();
        for (Row row : sheet) {
            BangLuongDTO item = new BangLuongDTO();
            boolean isFirstRow = false;
            for (Cell cell : row) {
                if (cell.getRowIndex() == 0) {
                    isFirstRow = true;
                    break;
                }
                switch (cell.getColumnIndex() + 1) {
                    case 1 -> item.setMaNV(cell.getStringCellValue());
                    case 2 -> item.setMaLuong(cell.getStringCellValue());
                    case 3 -> item.setTenNV(cell.getStringCellValue());
                    case 4 -> item.setNgayLapBang(new java.sql.Date(cell.getDateCellValue().getTime()));
                    case 5 -> item.setLuongCoBan(cell.getNumericCellValue());
                    case 6 -> item.setHeSoLuong(cell.getErrorCellValue());
                    case 7 -> item.setThuongPhat(cell.getNumericCellValue());
                    case 8 -> item.setTienLuong(cell.getNumericCellValue());
                    case 9 -> item.setNgaySuaDoi(new java.sql.Date(cell.getDateCellValue().getTime()));
                }
            }
            if (!isFirstRow && !"".equals(item.getMaNV())) {
                bangluongdao.addBangLuong(item);
            }
        }
        workbook.close();
        inputStream.close();

        return true;
    }

    public boolean exportBangLuong(String filepath) throws FileNotFoundException, IOException {
        FileOutputStream outputStream = new FileOutputStream(new File(filepath));
        Workbook workbook = getWorkbook(filepath);

        Sheet sheet = workbook.createSheet("NhanVien");

        ArrayList<BangLuongDTO> nhanvien = bangluongdao.getBangLuong();
        int rowIndex = 0;

        writeHeader(sheet, rowIndex);
        rowIndex++;

        for (BangLuongDTO item : nhanvien) {
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

        cell = row.createCell(COLUMN_INDEX_MALUONG);
        cell.setCellValue("Hình nhân viên");

        cell = row.createCell(COLUMN_INDEX_TENNV);
        cell.setCellValue("Tên nhân viên");

        cell = row.createCell(COLUMN_INDEX_NGAYLAPBANG);
        cell.setCellValue("Ngày sinh");

        cell = row.createCell(COLUMN_INDEX_LUONGCOBAN);
        cell.setCellValue("Giới tính");

        cell = row.createCell(COLUMN_INDEX_HESOLUONG);
        cell.setCellValue("Địa chỉ");

        cell = row.createCell(COLUMN_INDEX_THUONGPHAT);
        cell.setCellValue("Số CMND");

        cell = row.createCell(COLUMN_INDEX_TIENLUONG);
        cell.setCellValue("Số điện thoại");

        cell = row.createCell(COLUMN_INDEX_NGAYSUADOI);
        cell.setCellValue("Email");
    }

    protected void writeData(BangLuongDTO item, Row row) {
        Cell cell = row.createCell(COLUMN_INDEX_MANV);
        cell.setCellValue(item.getMaNV());

        cell = row.createCell(COLUMN_INDEX_MALUONG);
        cell.setCellValue(item.getMaLuong());

        cell = row.createCell(COLUMN_INDEX_TENNV);
        cell.setCellValue(item.getTenNV());

        cell = row.createCell(COLUMN_INDEX_NGAYLAPBANG);
        cell.setCellValue(item.getNgayLapBang());

        cell = row.createCell(COLUMN_INDEX_LUONGCOBAN);
        cell.setCellValue(item.getLuongCoBan());

        cell = row.createCell(COLUMN_INDEX_HESOLUONG);
        cell.setCellValue(item.getHeSoLuong());

        cell = row.createCell(COLUMN_INDEX_THUONGPHAT);
        cell.setCellValue(item.getThuongPhat());

        cell = row.createCell(COLUMN_INDEX_TIENLUONG);
        cell.setCellValue(item.getTienLuong());

        cell = row.createCell(COLUMN_INDEX_NGAYSUADOI);
        cell.setCellValue(item.getNgaySuaDoi());
    }
}
