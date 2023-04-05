/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DAO.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HHH
 */
public class ReportData {

    public void reportNhanVien() {
         report("src/Report/reportNhanVien.jrxml");
    }
    
    public void reportBangLuong() {
        report("src/Report/reportBangLuong.jrxml");
    }
    
    private void report(String filepath) {
        try {
            Hashtable map = new Hashtable();
            Connection conn = DBConnection.getConnection();
            JasperReport rpt = JasperCompileManager.compileReport(filepath);
            JasperPrint p = JasperFillManager.fillReport(rpt, map, conn);
            JasperViewer.viewReport(p, false);

            conn.close();

        } catch (JRException ex) {
            Logger.getLogger(ReportData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
