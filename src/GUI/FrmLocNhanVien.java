/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chicu
 */
public class FrmLocNhanVien extends javax.swing.JDialog {

    public NhanVienDTO nhanVienDTO;
    public NhanVienBUS nhanVienBUS;
    public FrmDSNV frmDSNV = new FrmDSNV();
    public FrmMain frmMain;
    public DefaultTableModel defaultTableModel = new DefaultTableModel();
    
    public FrmLocNhanVien(){
        
    }
    /**
     * Creates new form FrmLocNhanVien1
     */
    public FrmLocNhanVien(java.awt.Frame parent, JTable dataTable) {
        super(parent);
        initComponents();
        nhanVienDTO = new NhanVienDTO();
        nhanVienBUS = new NhanVienBUS();
        dataTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã NV");
        defaultTableModel.addColumn("Hình NV");
        defaultTableModel.addColumn("Tên NV");
        defaultTableModel.addColumn("Ngày sinh");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Địa chỉ");
        defaultTableModel.addColumn("Số CMND");
        defaultTableModel.addColumn("Số điện thoại");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Mã PB");
        defaultTableModel.addColumn("Mã CV");
        defaultTableModel.addColumn("Mã TDHV");

        setEmployeeData(nhanVienBUS.getNhanVien());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CVField = new javax.swing.JTextField();
        filterEmailField = new javax.swing.JTextField();
        filterCancelBtn = new javax.swing.JButton();
        PBField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        TDHVField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        filterIDNumField = new javax.swing.JTextField();
        filterNameField = new javax.swing.JTextField();
        filterBtn = new javax.swing.JButton();
        filterAddressField = new javax.swing.JTextField();
        filterBirthdayField = new javax.swing.JTextField();
        filterPhoneNumField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        gioitinhCBB = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        calendarBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        filterCancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/huy.png"))); // NOI18N
        filterCancelBtn.setText("Hủy");
        filterCancelBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        filterCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterCancelBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Ngày sinh:");

        jLabel10.setText("Mã CV");

        jLabel4.setText("Giới tính:");

        jLabel11.setText("Mã TDHV");

        jLabel5.setText("Địa chỉ:");

        jLabel6.setText("Số CMND:");

        jLabel7.setText("Số điện thoại:");

        jLabel8.setText("Email: ");

        filterBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/loc.png"))); // NOI18N
        filterBtn.setText("Lọc");
        filterBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        filterBtn.setPreferredSize(new java.awt.Dimension(44, 18));
        filterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBtnActionPerformed(evt);
            }
        });

        filterBirthdayField.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Chọn thông tin cần lọc");

        gioitinhCBB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chọn giới tính", "Nam", "Nữ" }));

        jLabel2.setText("Tên:");

        jLabel9.setText("Mã PB");

        calendarBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        calendarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/calendar.jpg"))); // NOI18N
        calendarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        calendarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calendarBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(filterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(filterCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(filterBirthdayField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calendarBtn))
                            .addComponent(filterNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(28, 28, 28)
                        .addComponent(TDHVField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CVField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PBField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterPhoneNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterIDNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gioitinhCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterBirthdayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(calendarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(gioitinhCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterIDNumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterPhoneNumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(PBField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CVField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TDHVField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filterCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterCancelBtnActionPerformed
        // TODO add your handling code here:
        filterAddressField.setText("");
        filterBirthdayField.setText("");
        filterEmailField.setText("");
        filterIDNumField.setText("");
        filterNameField.setText("");
        filterPhoneNumField.setText("");
    }//GEN-LAST:event_filterCancelBtnActionPerformed

    public void showCalendar(JLabel btn) {
        JDialog dialog = new JDialog(frmMain, "Calendar", true);
        dialog.setSize(158, 170);
        dialog.setLocation(calendarBtn.getX() + 700, calendarBtn.getY() + 200);
        dialog.add(new FrmCalendar(filterBirthdayField, dialog));
        dialog.setVisible(true);
    }

    private void filterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBtnActionPerformed
        // TODO add your handling code here:
        String TenNV = filterNameField.getText().trim();
        String NgaySinh = filterBirthdayField.getText().trim();
        String GioiTinh = gioitinhCBB.getSelectedItem().toString();
        String MaCV = CVField.getText().trim();
        String MaTDHV = TDHVField.getText().trim();
        String MaPB = PBField.getText().trim();
        String DiaChi = filterAddressField.getText().trim();
        String Email = filterEmailField.getText().trim();
        String SoCMND = filterIDNumField.getText().trim();
        String SoDienThoai = filterPhoneNumField.getText().trim();
        if (!"".equals(TenNV)) {
            nhanVienDTO.setTenNV(TenNV);
        }
        if (!"".equals(SoCMND)) {
            nhanVienDTO.setSoCMND(SoCMND);

        }
        if (!"".equals(SoDienThoai)) {
            nhanVienDTO.setSoDienThoai(SoDienThoai);

        }
        if (!"".equals(NgaySinh)) {
            nhanVienDTO.setNgaySinh(NgaySinh);

        }
        if (!"".equals(MaTDHV)) {
            nhanVienDTO.setMaTDHV(MaTDHV);

        }
        if (!"".equals(MaPB)) {
            nhanVienDTO.setMaPB(MaPB);

        }
        if (!"".equals(MaCV)) {
            nhanVienDTO.setMaCV(MaCV);

        }
        if (!"".equals(GioiTinh)) {
            if ("Nam".equals(GioiTinh) || "Nữ".equals(GioiTinh)) {
                nhanVienDTO.setGioiTinh(GioiTinh);
            }
        }
        if (!"".equals(Email)) {
            nhanVienDTO.setEmail(Email);

        }
        if (!"".equals(DiaChi)) {
            nhanVienDTO.setDiaChi(DiaChi);

        }

        defaultTableModel.setRowCount(0);
        setEmployeeData(nhanVienBUS.findNhanVienByFilter(nhanVienDTO));
        this.dispose();
    }//GEN-LAST:event_filterBtnActionPerformed

    public void setEmployeeData(ArrayList<NhanVienDTO> employees) {
        for (NhanVienDTO employee : employees) {
            defaultTableModel.addRow(new Object[]{
                employee.getMaNV(),
                employee.getHinhNV(),
                employee.getTenNV(),
                employee.getNgaySinh(),
                employee.getGioiTinh(),
                employee.getDiaChi(),
                employee.getSoCMND(),
                employee.getSoDienThoai(),
                employee.getEmail(),
                employee.getMaPB(),
                employee.getMaCV(),
                employee.getMaTDHV(),});
        }
    }

    private void calendarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarBtnMouseClicked
        // TODO add your handling code here:
        showCalendar(calendarBtn);
    }//GEN-LAST:event_calendarBtnMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CVField;
    private javax.swing.JTextField PBField;
    private javax.swing.JTextField TDHVField;
    private javax.swing.JLabel calendarBtn;
    private javax.swing.JTextField filterAddressField;
    private javax.swing.JTextField filterBirthdayField;
    private javax.swing.JButton filterBtn;
    private javax.swing.JButton filterCancelBtn;
    private javax.swing.JTextField filterEmailField;
    private javax.swing.JTextField filterIDNumField;
    private javax.swing.JTextField filterNameField;
    private javax.swing.JTextField filterPhoneNumField;
    private javax.swing.JComboBox gioitinhCBB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
