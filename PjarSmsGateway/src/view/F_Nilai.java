/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import main.DatabaseConnection;
import main.SmsGateway;
import main.TableListener;

/**
 *
 * @author indraarianggi
 */
public class F_Nilai extends javax.swing.JFrame {
    
    private DatabaseConnection kon;
    private String kueri;
    public static int modeformnilai;
    public static String n_id;

    /**
     * Creates new form F_Nilai
     */
    public F_Nilai() {
        initComponents();
        setResizable(false);
        kon = new DatabaseConnection();
        modeformnilai = 0;
        String n_id = "";
        
        setCbClass();
        setCbSubject();
        
        try {
            getData();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(F_Nilai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(F_Nilai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(F_Nilai.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //digunakan untuk mengambil respon klik user di header table
        //JTableHeader header = tblPraktikan.getTableHeader();
        //header.addMouseListener(new TableListener(tblPraktikan));
        
        //digunakan untuk mengambil respon klik di baris
        tblNilai.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row = tblNilai.rowAtPoint(evt.getPoint());
                int col = tblNilai.columnAtPoint(evt.getPoint());
                //JOptionPane.showMessageDialog(null, "baris ke - "+row);
                if(col!=0){
                    Boolean check = Boolean.valueOf(tblNilai.getValueAt(row, 0).toString());
                    if(check){
                        tblNilai.setValueAt(false, row, 0);
                    }else{
                        tblNilai.setValueAt(true, row, 0);
                    }
                }
            }
        });
        
        cbClass.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kelas = cbClass.getSelectedItem().toString().toUpperCase();
                String matprak = cbSubject.getSelectedItem().toString().toUpperCase();
                String nama = txtName.getText();
                
                searchData(kelas, matprak, nama);
            }
        });
        
        cbSubject.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kelas = cbClass.getSelectedItem().toString().toUpperCase();
                String matprak = cbSubject.getSelectedItem().toString().toUpperCase();
                String nama = txtName.getText();
                
                searchData(kelas, matprak, nama);
            }
        });
        
        txtName.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String kelas = cbClass.getSelectedItem().toString().toUpperCase();
                String matprak = cbSubject.getSelectedItem().toString().toUpperCase();
                String nama = txtName.getText();
                
                searchData(kelas, matprak, nama);
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                String kelas = cbClass.getSelectedItem().toString().toUpperCase();
                String matprak = cbSubject.getSelectedItem().toString().toUpperCase();
                String nama = txtName.getText();
                
                searchData(kelas, matprak, nama);
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println(txtName.getText());
            }
        });
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
        btnClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNilai = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbClass = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnMessage = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbSubject = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NILAI");

        btnClose.setBackground(new java.awt.Color(0, 153, 102));
        btnClose.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnClose.setForeground(new java.awt.Color(0, 153, 102));
        btnClose.setText("CLOSE");
        btnClose.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnClose.setContentAreaFilled(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        tblNilai.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNilaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNilai);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Class : ");

        cbClass.setBackground(new java.awt.Color(0, 153, 102));
        cbClass.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbClass.setForeground(new java.awt.Color(0, 153, 102));
        cbClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "all" }));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name : ");

        txtName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnAdd.setBackground(new java.awt.Color(0, 153, 102));
        btnAdd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 153, 102));
        btnAdd.setText("ADD NILAI");
        btnAdd.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnMessage.setBackground(new java.awt.Color(0, 153, 102));
        btnMessage.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnMessage.setForeground(new java.awt.Color(0, 153, 102));
        btnMessage.setText("MESSAGE");
        btnMessage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnMessage.setContentAreaFilled(false);
        btnMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 153, 102));
        btnEdit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(0, 153, 102));
        btnEdit.setText("EDIT");
        btnEdit.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEdit.setContentAreaFilled(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 153, 102));
        btnDelete.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 153, 102));
        btnDelete.setText("DELETE");
        btnDelete.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnDelete.setContentAreaFilled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Subject : ");

        cbSubject.setForeground(new java.awt.Color(0, 153, 102));
        cbSubject.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "all" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(cbClass, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(cbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
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

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        modeformnilai = 0;
        this.setVisible(false);        
        F_FormNilai form_nilai = new F_FormNilai("Add Nilai");
        form_nilai.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if(modeformnilai == 1){
            int row = tblNilai.getSelectedRow();
            n_id = (String) tblNilai.getValueAt(row, 3);
            this.setVisible(false);
            new F_FormNilai("Edit Data Nilai").setVisible(true);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tblNilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNilaiMouseClicked
        // TODO add your handling code here:
        modeformnilai = 1;
    }//GEN-LAST:event_tblNilaiMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(modeformnilai == 1){
            int row = tblNilai.getSelectedRow();
            n_id = (String) tblNilai.getValueAt(row, 3);
            try {
                Statement stasql = (Statement)kon.Connect().createStatement(); 
                kueri=("delete from nilai where id = '"+n_id+"';");
                stasql.executeUpdate(kueri);
                stasql.close();
                JOptionPane.showMessageDialog(null,"Record Telah Dihapus");
                this.setVisible(false);
                new F_Nilai().setVisible(true);
            } catch(Exception t){
                JOptionPane.showMessageDialog(null,"Record Gagal Dihapus\nTerdapat Kesalahan Pada Program");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageActionPerformed
        // TODO add your handling code here:
        if(modeformnilai == 1){
            int count_check = 0;
            ArrayList telepon = new ArrayList();
            ArrayList pesan = new ArrayList();
            for(int i = 0;i<tblNilai.getRowCount();i++){
                Boolean check = Boolean.valueOf(tblNilai.getValueAt(i,0).toString());
                String npm = tblNilai.getValueAt(i, 4).toString();
                if(check){
                    // Ambil nomor telepon praktikan
                    try {
                        Statement stasql = (Statement)kon.Connect().createStatement();
                        kueri=("SELECT telepon FROM praktikan WHERE npm = '"+npm+"';");
                        ResultSet rs = stasql.executeQuery(kueri);
                        while(rs.next()) {
                            count_check +=1;
                            telepon.add(rs.getString("telepon"));
                        }
                        rs.close();
                        stasql.close();
                    } catch(Exception t){
                        JOptionPane.showMessageDialog(null,"Gagal Mendapatkan Nomor Telepon Praktikan");
                    }
                    
                    // Bentuk Pesan
                    String nama = tblNilai.getValueAt(i, 5).toString();
                    String kelas = tblNilai.getValueAt(i, 6).toString();
                    String matprak = tblNilai.getValueAt(i, 2).toString();
                    String minggu1 = tblNilai.getValueAt(i, 7).toString();
                    String minggu2 = tblNilai.getValueAt(i, 8).toString();
                    String minggu3 = tblNilai.getValueAt(i, 9).toString();
                    String minggu4 = tblNilai.getValueAt(i, 10).toString();
                    String minggu5 = tblNilai.getValueAt(i, 11).toString();
                    String minggu6 = tblNilai.getValueAt(i, 12).toString();
                    String minggu7 = tblNilai.getValueAt(i, 13).toString();
                    String minggu8 = tblNilai.getValueAt(i, 14).toString();
                    
                    String isipesan = "===== Rekap Nilai Lab SK Lanjut =====";
                    isipesan += "\nNama Praktikan   : " + nama;
                    isipesan += "\nNPM              : " + npm;
                    isipesan += "\nKelas            : " + kelas;
                    isipesan += "\nMata Praktikum   : " + matprak;
                    isipesan += "\n===================================";
                    isipesan += "\nNilai ke-1      : " + minggu1;
                    isipesan += "\nNilai ke-2      : " + minggu2;
                    isipesan += "\nNilai ke-3      : " + minggu3;
                    isipesan += "\nNilai ke-4      : " + minggu4;
                    isipesan += "\nNilai ke-5      : " + minggu5;
                    isipesan += "\nNilai ke-6      : " + minggu6;
                    isipesan += "\nNilai ke-7      : " + minggu7;
                    isipesan += "\nNilai ke-8      : " + minggu8;
                    isipesan += "\n===================================\n";
                    
                    pesan.add(isipesan);
                }
            }
            for(int i=0;i<telepon.size();i++){
                System.out.println(telepon.get(i).toString());
            }
            try {
                //pgBar.setVisible(true);
                // BUKA F_FormMessage !!!!
                F_FormMessage form_message = new F_FormMessage("Send Nilai To Praktikan", telepon, pesan);
                form_message.setVisible(true);
                //pesan.sendMessage(hp, txt_pesan.getText());
                //pgBar.setVisible(false);
            } catch (Exception ex) {
                Logger.getLogger(F_Asisten.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnMessageActionPerformed

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
            java.util.logging.Logger.getLogger(F_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Nilai().setVisible(true);
            }
        });
    }
    
    public void setCbClass() {
        try{
            Statement stasql = (Statement)kon.Connect().createStatement();
            ResultSet runkueri = stasql.executeQuery("select distinct kelas from praktikan");
            while (runkueri.next()) {
                cbClass.addItem(runkueri.getString("kelas"));
            }
            stasql.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Gagal mengambil data kelas");
        }
    }
    
    public void setCbSubject() {
        try{
            Statement stasql = (Statement)kon.Connect().createStatement();
            ResultSet runkueri = stasql.executeQuery("select * from matprak");
            while (runkueri.next()) {
                cbSubject.addItem(runkueri.getString("praktikum"));
            }
            stasql.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Gagal mengambil data mata praktikum");
        }
    }
    
    private void searchData(String kelas, String matprak, String nama) {
        try {
            if(kelas=="ALL" && matprak=="ALL" && nama==""){
                getData();
            }else if(matprak=="ALL" && nama==""){
                getData(kelas);
            } else if (kelas=="ALL" && nama=="") {
                getData(matprak);
            } else if (kelas=="ALL" && matprak=="ALL") {
                getData(nama);
            } else {
                getData(kelas, matprak, nama);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(F_Nilai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(F_Nilai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(F_Nilai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getData() throws ClassNotFoundException, SQLException, IOException{
        String query = "SELECT nilai.praktikum, nilai.id, praktikan.npm, praktikan.nama, praktikan.kelas, nilai.nilai1, nilai.nilai2, nilai.nilai3, nilai.nilai4, nilai.nilai5, nilai.nilai6, nilai.nilai7, nilai.nilai8 FROM nilai INNER JOIN praktikan ON nilai.id_praktikan=praktikan.id;";
        Statement st = kon.Connect().createStatement();
        ResultSet sql = st.executeQuery(query);
        
        int baris=1;
        int i=0;
        
        customTableModel c_model = new customTableModel();
        
        while(sql.next()){
            baris++;
        }
        
        sql.beforeFirst();
        
        while(sql.next()){
            c_model.addRow(new Object[]{
                false,
                Integer.toString(i+1),
                sql.getString("nilai.praktikum"),
                sql.getString("nilai.id"),
                sql.getString("praktikan.npm"),
                sql.getString("praktikan.nama"),
                sql.getString("praktikan.kelas"),
                sql.getString("nilai.nilai1"),
                sql.getString("nilai.nilai2"),
                sql.getString("nilai.nilai3"),
                sql.getString("nilai.nilai4"),
                sql.getString("nilai.nilai5"),
                sql.getString("nilai.nilai6"),
                sql.getString("nilai.nilai7"),
                sql.getString("nilai.nilai8")
            });
            i++;
        }
        
        String namakolom[] = {"","No","Praktikum","ID","NPM","Nama", "Kelas", "Nilai 1", "Nilai 2", "Nilai 3", "Nilai 4", "Nilai 5", "Nilai 6", "Nilai 7", "Nilai 8"};
        //DefaultTableModel model = new DefaultTableModel(isi,namakolom);
        
        tblNilai.setModel(c_model);
    }
    
    private void getData(String cari) throws ClassNotFoundException, SQLException, IOException{
        String query = "SELECT nilai.praktikum, nilai.id, praktikan.npm, praktikan.nama, praktikan.kelas, nilai.nilai1, nilai.nilai2, nilai.nilai3, nilai.nilai4, nilai.nilai5, nilai.nilai6, nilai.nilai7, nilai.nilai8 FROM nilai INNER JOIN praktikan ON nilai.id_praktikan=praktikan.id WHERE praktikan.kelas like '%"+cari+"%' || nilai.praktikum like '%"+cari+"%' || praktikan.nama like '%"+cari+"%'";
        Statement st = kon.Connect().createStatement();
        ResultSet sql = st.executeQuery(query);
        
        int baris=1;
        int i=0;
        
        customTableModel c_model = new customTableModel();
        
        while(sql.next()){
            baris++;
        }
        
        sql.beforeFirst();
        
        while(sql.next()){
            c_model.addRow(new Object[]{
                false,
                Integer.toString(i+1),
                sql.getString("nilai.praktikum"),
                sql.getString("nilai.id"),
                sql.getString("praktikan.npm"),
                sql.getString("praktikan.nama"),
                sql.getString("praktikan.kelas"),
                sql.getString("nilai.nilai1"),
                sql.getString("nilai.nilai2"),
                sql.getString("nilai.nilai3"),
                sql.getString("nilai.nilai4"),
                sql.getString("nilai.nilai5"),
                sql.getString("nilai.nilai6"),
                sql.getString("nilai.nilai7"),
                sql.getString("nilai.nilai8")
            });
            i++;
        }
        
        String namakolom[] = {"","No","Praktikum","ID","NPM","Nama", "Kelas", "Nilai 1", "Nilai 2", "Nilai 3", "Nilai 4", "Nilai 5", "Nilai 6", "Nilai 7", "Nilai 8"};
        //DefaultTableModel model = new DefaultTableModel(isi,namakolom);
        
        tblNilai.setModel(c_model);
    }
    
    private void getData(String kelas, String matprak, String nama) throws ClassNotFoundException, SQLException, IOException{
        String query = "SELECT nilai.praktikum, nilai.id, praktikan.npm, praktikan.nama, praktikan.kelas, nilai.nilai1, nilai.nilai2, nilai.nilai3, nilai.nilai4, nilai.nilai5, nilai.nilai6, nilai.nilai7, nilai.nilai8 FROM absensi INNER JOIN praktikan ON nilai.id_praktikan=praktikan.id WHERE praktikan.kelas='"+kelas+"' && nilai.praktikum='"+matprak+"' && praktikan.nama like '%"+nama+"%'";
        Statement st = kon.Connect().createStatement();
        ResultSet sql = st.executeQuery(query);
        
        int baris=1;
        int i=0;
        
        customTableModel c_model = new customTableModel();
        
        while(sql.next()){
            baris++;
        }
        
        sql.beforeFirst();
        
        while(sql.next()){
            c_model.addRow(new Object[]{
                false,
                Integer.toString(i+1),
                sql.getString("nilai.praktikum"),
                sql.getString("nilai.id"),
                sql.getString("praktikan.npm"),
                sql.getString("praktikan.nama"),
                sql.getString("praktikan.kelas"),
                sql.getString("nilai.nilai1"),
                sql.getString("nilai.nilai2"),
                sql.getString("nilai.nilai3"),
                sql.getString("nilai.nilai4"),
                sql.getString("nilai.nilai5"),
                sql.getString("nilai.nilai6"),
                sql.getString("nilai.nilai7"),
                sql.getString("nilai.nilai8")
            });
            i++;
        }
        
        String namakolom[] = {"","No","Praktikum","ID","NPM","Nama", "Kelas", "Nilai 1", "Nilai 2", "Nilai 3", "Nilai 4", "Nilai 5", "Nilai 6", "Nilai 7", "Nilai 8"};
        //DefaultTableModel model = new DefaultTableModel(isi,namakolom);
        
        tblNilai.setModel(c_model);
    }
    
    private class customTableModel extends DefaultTableModel{
        public customTableModel() {
            super(new String[]{"Ceklis","No","Praktikum","ID","NPM","Nama", "Kelas", "Nilai 1", "Nilai 2", "Nilai 3", "Nilai 4", "Nilai 5", "Nilai 6", "Nilai 7", "Nilai 8"},0);
        }
        
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch(columnIndex){
                case 0 :
                    return Boolean.class;
                case 1 :
                    return String.class;
                case 2 :
                    return String.class;
                case 3 :
                    return String.class;
                case 4 :
                    return String.class;
                case 5 :
                    return String.class;
                case 6 :
                    return String.class;
                case 7 :
                    return String.class;
                case 8 :
                    return String.class;
                case 9 :
                    return String.class;
                case 10 :
                    return String.class;
                case 11 :
                    return String.class;
                case 12 :
                    return String.class;
                case 13 :
                    return String.class;
                case 14 :
                    return String.class;
                default :
                    return String.class;
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnMessage;
    private javax.swing.JComboBox cbClass;
    private javax.swing.JComboBox cbSubject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNilai;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
