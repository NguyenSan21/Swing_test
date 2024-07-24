/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package StudentManagerSwing;

import StudentManagerSwing.ClassFolder.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public final class frmQuanLySinhVien extends javax.swing.JFrame {

    /**
     * Creates new form frmQuanLyMonHoc
     */
    Connection cnn;
    Statement st;
    PreparedStatement pstm;
    int CheckGender;
    ConnectDB objcn = new ConnectDB();
    public frmQuanLySinhVien() throws ClassNotFoundException, SQLException {
        initComponents();
        cnn = objcn.Connect();
//        getMonHoc();
        getComboxMaKhoa();
        
    }
    public void setTextNull(){
        txtMaSV.setText("");
        txtTenSV.setText("");
        txtQueQuan.setText("");
        
    
    }
    public String getGender(){
        String i = "";
        if (JRadioNam.isSelected()){
            i = "Nam";
        }
        else if (JRadioNu.isSelected()){
            i = "Nữ";
        }
        return i;
    }
//    public int getGenderSQL(){
//        int i = 0;
//        if (JRadioNam.isSelected()){
//            i = 0;
//        }
//        else if (JRadioNu.isSelected()){
//            i = 1;
//        }
//        return i;
//    }
    public void getComboxMaKhoa(){
        String sql = "SELECT * FROM dbo.LOP";
        try {
            pstm = cnn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            JComboxMaLop.addItem(rs.getString("MaLop"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(frmQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getSinhVien() throws SQLException {
        String sql = "Select * from dbo.SINHVIEN order by MaSV ASC";
        st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        DefaultTableModel tableModel = (DefaultTableModel) tblQuanLySinhVien.getModel();
        tableModel.setRowCount(0);
        String MaSV, TenSV, GioiTinh, NgaySinh, MaLop, QueQuan;
        while (rs.next()){
            MaSV = rs.getString(1);
            TenSV = rs.getString(2);
            GioiTinh = rs.getString(3);
            NgaySinh = rs.getString(4);
            MaLop = rs.getString(5);
            QueQuan = rs.getString(6);
             if ("0".equals(GioiTinh)){
                GioiTinh = "Nam";
            }
             else if ("1".equals(GioiTinh)){
                 GioiTinh = "Nữ";
             } 
            String [] row = {MaSV, TenSV, GioiTinh, NgaySinh, MaLop, QueQuan};
            tableModel.addRow(row);

        }
    }
    public void searchSinhVien(){
    String sql = "SELECT * FROM dbo.SINHVIEN WHERE (MaSV LIKE ? AND TenSV LIKE ? AND GioiTinh LIKE ? AND NgaySinh LIKE ? AND MaLop LIKE ? AND QueQuan LIKE ?) ";
        try (PreparedStatement ptsm = cnn.prepareStatement(sql)){
//            int i = getGenderSQL();
            ptsm.setString(1, "%" + txtMaSV.getText()+"%"); 
            ptsm.setString(2,"%" + txtTenSV.getText()+"%");
            ptsm.setString(3,"%" + CheckGender +"%");
            ptsm.setString(4,"%" + JDataChooserNgaySinh.getDateFormatString() +"%");
            ptsm.setString(5,"%" + JComboxMaLop.getSelectedItem()+"%");
            ptsm.setString(6,"%" + txtQueQuan.getText()+"%");
            
//        String sql = "SELECT * FROM dbo.MONHOC WHERE (MaMH LIKE ('%" + txtMaMH.getText() +"%') OR TenMH LIKE ('%" + txtTenMH.getText()+"%') OR SoTrinh LIKE ('%"+ txtSoTrinh.getText()+"%')) ";
//        try {
//            st = cnn.createStatement();
            ResultSet rs = ptsm.executeQuery();
//            if (rs.wasNull() == true){
//                JOptionPane.showConfirmDialog(rootPane, "Không có dữ liệu", "Thông báo", WIDTH);
//            }
            DefaultTableModel tableModel = (DefaultTableModel) tblQuanLySinhVien.getModel();
            tableModel.setRowCount(0);
            String MaSV, TenSV, GioiTinh, NgaySinh, MaLop, QueQuan;
            
        while (rs.next()){

            MaSV = rs.getString(1);
            TenSV = rs.getString(2);
            GioiTinh = rs.getString(3);
            NgaySinh = rs.getString(4);
            MaLop = rs.getString(5);
            QueQuan = rs.getString(6);
             if ("0".equals(GioiTinh)){
                GioiTinh = "Nam";
            }
             else if ("1".equals(GioiTinh)){
                 GioiTinh = "Nữ";
             } 
            Object [] row = {MaSV, TenSV, GioiTinh, NgaySinh, MaLop, QueQuan};
            tableModel.addRow(row);
        }        
        } catch (SQLException ex) {
            Logger.getLogger(frmQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuanLySinhVien = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtMaSV = new javax.swing.JTextField();
        txtTenSV = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnFix1 = new javax.swing.JButton();
        JComboxMaLop = new javax.swing.JComboBox<>();
        JRadioNam = new javax.swing.JRadioButton();
        JRadioNu = new javax.swing.JRadioButton();
        JDataChooserNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtQueQuan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN  LÝ SINH VIÊN");

        tblQuanLySinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Tên sinh viên", "Giới tính", "Ngày sinh", "Mã lớp", "Quê quán"
            }
        ));
        tblQuanLySinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanLySinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQuanLySinhVien);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Mã sinh viên");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Tên sinh viên");

        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAdd.setText("THÊM");
        btnAdd.setBorder(null);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDelete.setText("XÓA");
        btnDelete.setBorder(null);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtMaSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSVActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSearch.setText("TÌM KIẾM");
        btnSearch.setBorder(null);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnExit.setText("THOÁT");
        btnExit.setBorder(null);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Giới tính");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Ngày sinh");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Mã lớp");

        btnFix1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnFix1.setText("SỬA");
        btnFix1.setBorder(null);
        btnFix1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFix1ActionPerformed(evt);
            }
        });

        JComboxMaLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboxMaLopActionPerformed(evt);
            }
        });

        JRadioNam.setText("Nam");
        JRadioNam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JRadioNamMouseClicked(evt);
            }
        });

        JRadioNu.setText("Nữ");
        JRadioNu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JRadioNuMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Quê quán");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(208, 208, 208))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(btnFix1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(50, 50, 50))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JComboxMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTenSV, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(JRadioNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(JRadioNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(JDataChooserNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(txtQueQuan, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JRadioNam)
                    .addComponent(JRadioNu))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(JDataChooserNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JComboxMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFix1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String sql = "INSERT INTO dbo.SINHVIEN (MaSV, TenSV, GioiTinh, NgaySinh, MaLop, QueQuan) VALUES (?,?,?,?,?,?)";
        
        try {
//            int i = getGenderSQL();
            pstm = cnn.prepareStatement(sql);
            pstm.setString(1, txtMaSV.getText());
            pstm.setString(2, txtTenSV.getText());
            pstm.setString(3, ""+CheckGender+"");
            SimpleDateFormat sdfm = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdfm.format(JDataChooserNgaySinh.getDate());
            pstm.setString(4, date);
            pstm.setString(5, (String)JComboxMaLop.getSelectedItem());
            pstm.setString(6, txtQueQuan.getText());
            pstm.executeUpdate();
            setTextNull();
            getSinhVien();
            getComboxMaKhoa();
            
        } catch (SQLException ex) {
            Logger.getLogger(frmQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String sql = "DELETE FROM dbo.SINHVIEN WHERE MaSV =?";
        try {
            pstm = cnn.prepareStatement(sql);
            pstm.setString(1, txtMaSV.getText());
            int i = pstm.executeUpdate();
            setTextNull();
            getComboxMaKhoa();
            getSinhVien();
            if (i != 0){
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công", "Thông báo", HEIGHT);
            }
            else JOptionPane.showMessageDialog(rootPane, "Xóa thất bại", "Thông báo", HEIGHT);
        } catch (SQLException ex) {
            Logger.getLogger(frmQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblQuanLySinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLySinhVienMouseClicked
        // TODO add your handling code here:
        int selectRow = tblQuanLySinhVien.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblQuanLySinhVien.getModel();
        txtMaSV.setText(model.getValueAt(selectRow, 0).toString());
        txtTenSV.setText(model.getValueAt(selectRow, 1).toString());
        JDataChooserNgaySinh.setDateFormatString(model.getValueAt(selectRow, 3).toString());
        JComboxMaLop.setSelectedItem(model.getValueAt(selectRow,4).toString());
        txtQueQuan.setText(model.getValueAt(selectRow, 5).toString());
        
    }//GEN-LAST:event_tblQuanLySinhVienMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        searchSinhVien();
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        int ck = JOptionPane.showConfirmDialog(rootPane, "Thoát chức năng này?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (ck == JOptionPane.YES_OPTION){
        dispose();
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnFix1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFix1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFix1ActionPerformed

    private void txtMaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSVActionPerformed

    private void JComboxMaLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboxMaLopActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_JComboxMaLopActionPerformed

    private void JRadioNamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JRadioNamMouseClicked
        // TODO add your handling code here:
        if (JRadioNam.isSelected()){
        JRadioNam.setSelected(true); 
        JRadioNu.setSelected(false);
        
        }
        else {
            JRadioNam.setSelected(false);
            JRadioNu.setSelected(true);
            
        }
    }//GEN-LAST:event_JRadioNamMouseClicked

    private void JRadioNuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JRadioNuMouseClicked
        // TODO add your handling code here:
        if (JRadioNu.isSelected()){
        JRadioNu.setSelected(true); 
        JRadioNam.setSelected(false);
        
        }
        else {
            JRadioNu.setSelected(false);
            JRadioNam.setSelected(true);
            
        }
    }//GEN-LAST:event_JRadioNuMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmQuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmQuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmQuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmQuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new frmQuanLySinhVien().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(frmQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(frmQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboxMaLop;
    private com.toedter.calendar.JDateChooser JDataChooserNgaySinh;
    private javax.swing.JRadioButton JRadioNam;
    private javax.swing.JRadioButton JRadioNu;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFix1;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblQuanLySinhVien;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtQueQuan;
    private javax.swing.JTextField txtTenSV;
    // End of variables declaration//GEN-END:variables
}
