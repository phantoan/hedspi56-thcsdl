package UI;

import DButitilies.ConnectFactory;
import DButitilies.RetrieveData;
import Entities.Student;
import MVCmodel.StudentModel;
import Utilities.writexls;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import jxl.write.WriteException;

public class AdvanceSearchDialog extends javax.swing.JDialog {

    private ArrayList<Student> list = new ArrayList<>();
    private String usrName;
    private int role;

    public AdvanceSearchDialog(java.awt.Frame parent, boolean modal, String usrName, int role) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.usrName = usrName;
        this.role = role;
        ArrayList<String> deptNames = RetrieveData.getAllDeptName();
        ArrayList<String> claNames = RetrieveData.getAllClassName();
        DefaultComboBoxModel cbmDept = new DefaultComboBoxModel();
        DefaultComboBoxModel cbmClass = new DefaultComboBoxModel();
        for (String s : deptNames) {
            cbmDept.addElement(s);
        }
        cbmDept.addElement("All");
        cbxDept.setModel(cbmDept);
        for (String s : claNames) {
            cbmClass.addElement(s);
        }
        cbmClass.addElement("All");
        cbxClassName.setModel(cbmClass);
        this.setResizable(false);
        if (role == 1 || role == 2) {
            btnDelete.setVisible(true);
        } else {
            btnDelete.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnStudentAdv = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtF_Name = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        cbxDept = new javax.swing.JComboBox();
        btnClear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudentResultSearch = new javax.swing.JTable();
        txtL_Name = new javax.swing.JTextField();
        txtSchoolYear = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxClassName = new javax.swing.JComboBox();
        btnExport = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnStudentAdv.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnStudentAdv.setText("Search");
        btnStudentAdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentAdvActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("StudentID: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Address:");

        cbxDept.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CNTT & TT", "Hóa Học", "Điện", "All..." }));

        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Dept:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("School Year:");

        tblStudentResultSearch.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblStudentResultSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStudentResultSearch);

        jLabel6.setText("Class:");

        btnExport.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtID)
                                    .addComponent(txtAddress)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtF_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtL_Name)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxDept, 0, 121, Short.MAX_VALUE)
                                    .addComponent(txtSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxClassName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnStudentAdv)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExport)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbxDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtF_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtL_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbxClassName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStudentAdv)
                    .addComponent(btnClear)
                    .addComponent(btnExport)
                    .addComponent(btnDelete))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Search", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStudentAdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentAdvActionPerformed
        search();
    }//GEN-LAST:event_btnStudentAdvActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        int result;
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File("."));
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        result = jfc.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String fileName = jfc.getSelectedFile().getAbsolutePath();
            fileName += ".xls";
            try {
                writexls.writexlss(tblStudentResultSearch, fileName);
            } catch (WriteException ex) {
                Logger.getLogger(AdvanceSearchDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AdvanceSearchDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(rootPane, "Export success !", "Information", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtF_Name.setText("");
        txtL_Name.setText("");
        txtAddress.setText("");
        txtID.setText("");
        txtSchoolYear.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            Delete();
        } catch (SQLException ex) {
            Logger.getLogger(AdvanceSearchDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void search() {
        String strsql = new String();
        String MSSV = txtID.getText();
        String F_Name = txtF_Name.getText();
        String L_Name = txtL_Name.getText();
        String Address = txtAddress.getText();
        String Dept = (String) cbxDept.getSelectedItem();
        String Schoolyear = txtSchoolYear.getText();
        String ClassName = (String) cbxClassName.getSelectedItem();

        strsql = "SELECT DISTINCT \"Student\".\"StuID\",\"Student\".\"F_Name\","
                + "\"Student\".\"L_Name\",\"Birth\",\"Gender\",\"Student\".\"Year\","
                + "\"Student\".\"Tel\",\"Student\".\"Mail\",\"Address\",\"ClaName\",\"Des\""
                + "FROM \"Student\",\"Department\",\"Class\""
                + "WHERE (1=1) and \"Student\".\"ClaID\" =\"Class\".\"ClaID\""
                + "and \"Class\".\"DeptID\"= \"Department\".\"DeptID\"";

        if (!MSSV.equals("")) {
            strsql += " and \"StuID\"like '%" + MSSV + "%'";
        }
        if (!F_Name.equals("")) {
            strsql += " and  \"F_Name\"like '%" + F_Name + "%'";
        }
        if (!L_Name.equals("")) {
            strsql += " and  \"L_Name\"like '%" + L_Name + "%'";
        }
        if (!Address.equals("")) {
            strsql += " and \"Address\"like '%" + Address + "%'";
        }
        if (!Dept.equals("All")) {
            strsql += " and \"DeptName\"like '%" + Dept + "%'";
        }
        if (!Schoolyear.equals("")) {
            strsql += " and \"Student\".\"Year\" = " + Schoolyear;
        }
        if (!ClassName.equals("All")) {
            strsql += " and(\"Class\".\"ClaID\" like '" + ClassName + "' or \"Class\".\"ClaName\"like '" + ClassName + "')";
        }
        this.list.clear();
        try {
            ConnectFactory cf = new ConnectFactory();
            Connection conn = cf.getConn();
            PreparedStatement ps = conn.prepareCall(strsql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getBoolean(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11));
                list.add(s);
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdvanceSearchDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

        StudentModel sm = new StudentModel(list);
        tblStudentResultSearch.setModel(sm);

    }

    private void Delete() throws SQLException {
        int[] se = tblStudentResultSearch.getSelectedRows();
        String st;
        ConnectFactory cf = new ConnectFactory();
        Connection conn = cf.getConn();

        if (se.length != 0) {
            for (int y = 0; y < se.length; y++) {
                st = (String) tblStudentResultSearch.getValueAt(se[y], 0).toString();
                // System.out.println(st);
                try {
                    String strsql2 = "UPDATE \"Class\" SET \"MoniterID\"=NULL WHERE \"MoniterID\"='" + st + "'";
                    String strsql3 = "DELETE FROM \"Student\" WHERE \"StuID\"='" + st + "'";

                    PreparedStatement ps1 = conn.prepareCall(strsql2);
                    PreparedStatement ps2 = conn.prepareCall(strsql3);
                    int rs1 = ps1.executeUpdate();
                    int rs2 = ps2.executeUpdate();

                    search();
                } catch (SQLException ex) {
                    Logger.getLogger(AdvanceSearchDialog.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(AdvanceSearchDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdvanceSearchDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdvanceSearchDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdvanceSearchDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdvanceSearchDialog dialog = new AdvanceSearchDialog(new javax.swing.JFrame(), true, "admin", 1);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnStudentAdv;
    private javax.swing.JComboBox cbxClassName;
    private javax.swing.JComboBox cbxDept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblStudentResultSearch;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtF_Name;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtL_Name;
    private javax.swing.JTextField txtSchoolYear;
    // End of variables declaration//GEN-END:variables
}
