/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DButitilies.RetrieveData;
import Entities.User;
import Utilities.Utility;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Minh
 */
public class ResetPasswordForm extends javax.swing.JDialog {

    private String usrName;

    /**
     * Creates new form ResetPasswordForm
     */
    public ResetPasswordForm(java.awt.Frame parent, boolean modal, String usrName) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.usrName = usrName;
        this.setTitle("Confirm reset password " + usrName);
    }

    private User getUser(String usrName) {
        ArrayList<User> list = RetrieveData.getAllUser();
        for (User u : list) {
            if (u.getUserName().compareTo(usrName) == 0) {
                return u;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtOldPass = new javax.swing.JPasswordField();
        txtNewPass = new javax.swing.JPasswordField();
        txtRePass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Old password:");

        jLabel2.setText("New password:");

        jLabel3.setText("Re-Type :");

        jButton1.setText("Action");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(54, 54, 54)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNewPass, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(txtOldPass)
                    .addComponent(txtRePass))
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean check = false;
        String oldPass = new String(txtOldPass.getPassword());
        String oldPassMD5 = Utilities.Utility.checksumGen(oldPass, "MD5", true);
        String newPass = new String(txtNewPass.getPassword());
        String newRePass = new String(txtRePass.getPassword());
        User u = getUser(usrName);        
        if (u.getPassword().compareTo(oldPassMD5) == 0) {
            check = true;
        } else {
            check = false;
            JOptionPane.showMessageDialog(this, "This old password doesn't match");
        }
        if (newRePass.compareTo(newPass) == 0 && newRePass.compareTo("") != 0) {
            check = true;
            txtRePass.setBackground(Color.WHITE);
        } else {
            check = false;
            txtRePass.setBackground(Color.red);
            txtRePass.setToolTipText("Re-typed password doesn't match !");
        }
        if (check) {
            User nu = new User(usrName, u.getContact(), Utility.checksumGen(newPass, "MD5", true), u.getRole());
            RetrieveData.deleteUser(usrName);
            RetrieveData.createUser(nu);
            JOptionPane.showMessageDialog(this, "User " + nu.getUserName() + "has new password !");
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtNewPass;
    private javax.swing.JPasswordField txtOldPass;
    private javax.swing.JPasswordField txtRePass;
    // End of variables declaration//GEN-END:variables
}
