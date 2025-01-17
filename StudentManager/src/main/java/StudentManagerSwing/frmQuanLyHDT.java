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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public final class frmQuanLyHDT extends javax.swing.JFrame {

    /**
     * Creates new form frmQuanLyMonHoc
     */
    Connection cnn;
    Statement st;
    PreparedStatement pstm;
    ConnectDB objcn = new ConnectDB();
    public frmQuanLyHDT() throws ClassNotFoundException, SQLException {
        initComponents();
        cnn = objcn.Connect();
//        getMonHoc();
        
        
    }
    public void setTextNull(){
        txtMaHDT.setText("");
        txtTenHDT.setText("");
    
    }
    public void getHeDT() throws SQLException {
        String sql = "Select * from dbo.HEDT order by MaHDT ASC";
        st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        DefaultTableModel tableModel = (DefaultTableModel) tblQuanLyHDT.getModel();
        tableModel.setRowCount(0);
        String MaHDT, TenHDT;
        while (rs.next()){
            MaHDT = rs.getString(1);
            TenHDT = rs.getString(2);
            String [] row = {MaHDT, TenHDT};
            tableModel.addRow(row);

        }
    }
    public void searchHeDT(){
    String sql = "SELECT * FROM dbo.HEDT WHERE (MaHDT LIKE ? AND TenHDT LIKE ? ) ";
        try (PreparedStatement ptsm = cnn.prepareStatement(sql)){
            ptsm.setString(1, "%" + txtMaHDT.getText()+"%"); 
            ptsm.setString(2,"%" + txtTenHDT.getText()+"%");
           
            
//        String sql = "SELECT * FROM dbo.MONHOC WHERE (MaMH LIKE ('%" + txtMaMH.getText() +"%') OR TenMH LIKE ('%" + txtTenMH.getText()+"%') OR SoTrinh LIKE ('%"+ txtSoTrinh.getText()+"%')) ";
//        try {
//            st = cnn.createStatement();
            ResultSet rs = ptsm.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel) tblQuanLyHDT.getModel();
            tableModel.setRowCount(0);
            String MaHDT, TenHDT;
            
        while (rs.next()){
            MaHDT = rs.getString(1);
            TenHDT = rs.getString(2);
            Object [] row = {MaHDT, TenHDT};
            tableModel.addRow(row);
        }        
        } catch (SQLException ex) {
            Logger.getLogger(frmQuanLyHDT.class.getName()).log(Level.SEVERE, null, ex);
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
        tblQuanLyHDT = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnFix = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtMaHDT = new javax.swing.JTextField();
        txtTenHDT = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN  LÝ HỆ ĐÀO TẠO");

        tblQuanLyHDT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã HĐT", "Tên HĐT"
            }
        ));
        tblQuanLyHDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanLyHDTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQuanLyHDT);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Mã HĐT");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Tên HĐT");

        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAdd.setText("THÊM");
        btnAdd.setBorder(null);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnFix.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnFix.setText("SỬA");
        btnFix.setBorder(null);
        btnFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFixActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaHDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(50, 50, 50)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenHDT, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnFix, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(2, 2, 2)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenHDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFix, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String sql = "INSERT INTO dbo.HEDT (MaHDT,TenHDT) VALUES (?,?)";
        
        try {
            pstm = cnn.prepareStatement(sql);
            pstm.setString(1, txtMaHDT.getText());
            pstm.setString(2, txtTenHDT.getText());
            pstm.executeUpdate();
            setTextNull();
            getHeDT();
        } catch (SQLException ex) {
            Logger.getLogger(frmQuanLyHDT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFixActionPerformed
        // TODO add your handling code here:
        String sql="UPDATE dbo.HEDT SET TenHDT=? WHERE MaHDT =?";
        try {
           
            pstm = cnn.prepareStatement(sql);
           
            pstm.setString(1, txtTenHDT.getText());
            pstm.setString(2, txtMaHDT.getText());
            int i = pstm.executeUpdate();
            setTextNull();
            getHeDT();
            if(i != 0){
                JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công", "Thông báo", HEIGHT);
            }
            else JOptionPane.showMessageDialog(rootPane, "Cập nhật thất bại", "Thông báo", HEIGHT);
        } catch (SQLException ex) {
            Logger.getLogger(frmQuanLyHDT.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }//GEN-LAST:event_btnFixActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String sql = "DELETE FROM dbo.HEDT WHERE MaHDT=?";
        try {
            pstm = cnn.prepareStatement(sql);
            pstm.setString(1, txtMaHDT.getText());
            int i = pstm.executeUpdate();
            setTextNull();
            getHeDT();
            if (i != 0){
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công", "Thông báo", HEIGHT);
            }
            else JOptionPane.showMessageDialog(rootPane, "Xóa thất bại", "Thông báo", HEIGHT);
        } catch (SQLException ex) {
            Logger.getLogger(frmQuanLyHDT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblQuanLyHDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLyHDTMouseClicked
        // TODO add your handling code here:
        int selectRow = tblQuanLyHDT.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblQuanLyHDT.getModel();
        txtMaHDT.setText(model.getValueAt(selectRow, 0).toString());
        txtTenHDT.setText(model.getValueAt(selectRow, 1).toString());
        
    }//GEN-LAST:event_tblQuanLyHDTMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        searchHeDT();
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        int ck = JOptionPane.showConfirmDialog(rootPane, "Thoát chức năng này?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (ck == JOptionPane.YES_OPTION){
        dispose();
        }
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(frmQuanLyHDT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyHDT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyHDT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyHDT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                    new frmQuanLyHDT().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(frmQuanLyHDT.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(frmQuanLyHDT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFix;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblQuanLyHDT;
    private javax.swing.JTextField txtMaHDT;
    private javax.swing.JTextField txtTenHDT;
    // End of variables declaration//GEN-END:variables
}
