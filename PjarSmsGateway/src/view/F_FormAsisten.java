/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.DatabaseConnection;

import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author indraarianggi
 */
public class F_FormAsisten extends javax.swing.JFrame {
    
    private DatabaseConnection kon;
    private String nama, nomortlp, username, password, confpassword, batastxt;
    private String kueri;
    private String inputnomortlp;
    
    /**
     * Creates new form F_FormAsisten
     */
    public F_FormAsisten() {
        initComponents();
        setResizable(false);
    }
    
    public F_FormAsisten(String formTitle) {
        setResizable(false);
        initComponents();
        lblTitle.setText(formTitle);
        kon = new DatabaseConnection();
        
        if(F_Asisten.modeformasisten == 1){
            try{
                Statement stasql = (Statement)kon.Connect().createStatement();
                kueri=("select nama,telepon from asisten where id = '"+F_Asisten.n_id+"';");
                ResultSet rs = stasql.executeQuery(kueri);
                while(rs.next()){
                   String datanama = rs.getString("nama");
                   String datanomortlp = rs.getString("telepon");
                   //JOptionPane.showMessageDialog(null,"Sip");
                   txtName.setText(datanama);
                   txtNoTelp.setText(datanomortlp);                   
                }
                rs.close();
                stasql.close();
                
                lblUsername.setVisible(false);
                txtUsername.setVisible(false);
                lblPassword.setVisible(false);
                txtPassword.setVisible(false);
                lblConfPassword.setVisible(false);
                txtConfPassword.setVisible(false);
            } catch(Exception t){
                JOptionPane.showMessageDialog(null,"Terdapat Kesalahan Pada Program");
            }
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        lblConfPassword = new javax.swing.JLabel();
        txtConfPassword = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblNoTelp = new javax.swing.JLabel();
        txtNoTelp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Form Asisten");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Nama Asisten");

        lblTitle.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 153, 153));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Form Title");

        txtName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        lblUsername.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Username");

        txtUsername.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsernameKeyTyped(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password");

        txtPassword.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblConfPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblConfPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblConfPassword.setText("Conf Password");

        txtConfPassword.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnSave.setBackground(new java.awt.Color(0, 153, 102));
        btnSave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 153, 102));
        btnSave.setText("SAVE");
        btnSave.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSave.setContentAreaFilled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(0, 153, 102));
        btnCancel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(0, 153, 102));
        btnCancel.setText("CANCEL");
        btnCancel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCancel.setContentAreaFilled(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblNoTelp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNoTelp.setForeground(new java.awt.Color(255, 255, 255));
        lblNoTelp.setText("Telepon");

        txtNoTelp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNoTelp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoTelpKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblName)
                                .addComponent(lblUsername)
                                .addComponent(lblPassword)
                                .addComponent(lblConfPassword)
                                .addComponent(lblNoTelp))
                            .addGap(59, 59, 59)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtName)
                                .addComponent(txtUsername)
                                .addComponent(txtPassword)
                                .addComponent(txtConfPassword)
                                .addComponent(txtNoTelp))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitle)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoTelp)
                    .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfPassword)
                    .addComponent(txtConfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
//        this.setVisible(false);
//        new F_Asisten().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(F_Asisten.modeformasisten == 1){ // EDIT/MODIFY/UPDATE
            nama = txtName.getText();
            nomortlp = txtNoTelp.getText();
            
            if(nama.length() != 0 && nomortlp.length() != 0){
                try {
                    Statement stasql = (Statement)kon.Connect().createStatement(); 
                    kueri=("update asisten set nama = '"+nama+"', telepon = '"+nomortlp+"' where id = '"+F_Asisten.n_id+"';");
                    stasql.executeUpdate(kueri);
                    stasql.close();
                    JOptionPane.showMessageDialog(null,"Record Telah Diubah");
                    this.setVisible(false);
                    new F_Asisten().setVisible(true);
                } catch(Exception t){
                    JOptionPane.showMessageDialog(null,"Record Gagal Ditambah\nTerdapat Kesalahan Pada Program");
                }
            }
        } else { // ADD
            nama = txtName.getText();
            nomortlp = txtNoTelp.getText();
            username = txtUsername.getText();
            password = txtPassword.getText();
            confpassword = txtConfPassword.getText();
            
            if (password.equals(confpassword) && username.length() != 0 && password.length() != 0){
                try {
                    Statement stasql = (Statement)kon.Connect().createStatement();
                    kueri=("insert into asisten (nama,username,password,telepon) values ('"+nama+"','"+username+"','"+password+"','"+nomortlp+"');");
                    stasql.executeUpdate(kueri);
                    stasql.close();
                    JOptionPane.showMessageDialog(null,"Akun Asisten Baru Telah Ditambah");
                    this.setVisible(false);
                    new F_Asisten().setVisible(true);
                } catch(Exception t){
                    JOptionPane.showMessageDialog(null,"Pendaftaran Akun Gagal\nNama Pengguna Sudah Digunakan");
                }
            } else {
                JOptionPane.showMessageDialog(null,"Pendaftaran Akun Gagal");
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        // TODO add your handling code here:
        if(txtName.getText().length()<50){
            txtName.setEditable(true);
        } else {
            batastxt = txtName.getText().substring(0, 49);
            txtName.setText(batastxt);
        }
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtNoTelpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoTelpKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!((Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)))){
            evt.consume();
        }
        inputnomortlp = txtNoTelp.getText();
        if(inputnomortlp.length()<15){
            txtNoTelp.setEditable(true);
        }
        else {                    
            batastxt = inputnomortlp.substring(0, 14);
            txtNoTelp.setText(batastxt);
        }
    }//GEN-LAST:event_txtNoTelpKeyTyped

    private void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyTyped
        // TODO add your handling code here:
        if(txtUsername.getText().length()<20){
            txtUsername.setEditable(true);
        } else {
            batastxt = txtUsername.getText().substring(0, 19);
            txtUsername.setText(batastxt);
        }
    }//GEN-LAST:event_txtUsernameKeyTyped

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
            java.util.logging.Logger.getLogger(F_FormAsisten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_FormAsisten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_FormAsisten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_FormAsisten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_FormAsisten().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblConfPassword;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNoTelp;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtConfPassword;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNoTelp;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
