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
public class F_FormAbsensi extends javax.swing.JFrame {
    
    private DatabaseConnection kon;
    private String npm, nama, kelas, praktikum, minggu1, minggu2, minggu3, minggu4, minggu5, minggu6, minggu7, minggu8, batastxt;
    private String kueri, kueri2;
    private String id_praktikan = null;

    /**
     * Creates new form F_FormAbsensi
     */
    public F_FormAbsensi() {
        initComponents();
        setResizable(false);
    }
    
    public F_FormAbsensi(String formTitle) {
        setResizable(false);
        initComponents();
        lblTitle.setText(formTitle);
        kon = new DatabaseConnection();
        
        setCbPraktikum();
        
        if(F_Absensi.modeformabsensi == 1){
            try {
                Statement stasql = (Statement)kon.Connect().createStatement();
                kueri=("SELECT absensi.praktikum, praktikan.npm, praktikan.nama, praktikan.kelas, absensi.minggu1, absensi.minggu2, absensi.minggu3, absensi.minggu4, absensi.minggu5, absensi.minggu6, absensi.minggu7, absensi.minggu8 FROM absensi INNER JOIN praktikan ON absensi.id_praktikan=praktikan.id WHERE absensi.id='"+F_Absensi.n_id+"'");
                ResultSet rs = stasql.executeQuery(kueri);
                while(rs.next()){
                    String datanpm = rs.getString("praktikan.npm");
                    String datanama = rs.getString("praktikan.nama");
                    String datakelas = rs.getString("praktikan.kelas");
                    String datapraktikum = rs.getString("absensi.praktikum");
                    String dataminggu1 = rs.getString("absensi.minggu1");
                    String dataminggu2 = rs.getString("absensi.minggu2");
                    String dataminggu3 = rs.getString("absensi.minggu3");
                    String dataminggu4 = rs.getString("absensi.minggu4");
                    String dataminggu5 = rs.getString("absensi.minggu5");
                    String dataminggu6 = rs.getString("absensi.minggu6");
                    String dataminggu7 = rs.getString("absensi.minggu7");
                    String dataminggu8 = rs.getString("absensi.minggu8");
                    
                    txtNpm.setText(datanpm);
                    txtNpm.setEditable(false);
                    txtNama.setText(datanama);
                    txtNama.setEditable(false);
                    txtKelas.setText(datakelas);
                    txtKelas.setEditable(false);
                    cbPraktikum.setSelectedItem(datapraktikum);
                    cbPraktikum.setEditable(false);
                    cbPraktikum.setEnabled(false);
                    
                    cbMinggu1.setSelectedItem(dataminggu1);
                    cbMinggu2.setSelectedItem(dataminggu2);
                    cbMinggu3.setSelectedItem(dataminggu3);
                    cbMinggu4.setSelectedItem(dataminggu4);
                    cbMinggu5.setSelectedItem(dataminggu5);
                    cbMinggu6.setSelectedItem(dataminggu6);
                    cbMinggu7.setSelectedItem(dataminggu7);
                    cbMinggu8.setSelectedItem(dataminggu8);
                }
                rs.close();
                stasql.close();
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
        lblTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNpm = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtKelas = new javax.swing.JTextField();
        cbPraktikum = new javax.swing.JComboBox();
        cbMinggu1 = new javax.swing.JComboBox();
        cbMinggu2 = new javax.swing.JComboBox();
        cbMinggu3 = new javax.swing.JComboBox();
        cbMinggu4 = new javax.swing.JComboBox();
        cbMinggu5 = new javax.swing.JComboBox();
        cbMinggu6 = new javax.swing.JComboBox();
        cbMinggu7 = new javax.swing.JComboBox();
        cbMinggu8 = new javax.swing.JComboBox();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FORM ABSENSI");

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

        lblTitle.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 153, 153));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Form Title");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NPM");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama Praktikan");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kelas");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Praktikum");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Minggu 1");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Minggu 2");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Minggu 3");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Minggu 4");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Minggu 5");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Minggu 6");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Minggu 7");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Minggu 8");

        txtNpm.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNpm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNpmKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNpmKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNpmKeyTyped(evt);
            }
        });

        txtNama.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtKelas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cbPraktikum.setBackground(new java.awt.Color(0, 153, 102));
        cbPraktikum.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbPraktikum.setForeground(new java.awt.Color(0, 153, 102));

        cbMinggu1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1" }));

        cbMinggu2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1" }));

        cbMinggu3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1" }));

        cbMinggu4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1" }));

        cbMinggu5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1" }));

        cbMinggu6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1" }));

        cbMinggu7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1" }));

        cbMinggu8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1" }));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(55, 55, 55)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNpm)
                                        .addComponent(txtNama)
                                        .addComponent(txtKelas)
                                        .addComponent(cbPraktikum, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbMinggu3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbMinggu4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbMinggu2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(79, 79, 79)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbMinggu8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbMinggu7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbMinggu6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(cbMinggu1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(cbMinggu5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitle)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbPraktikum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(cbMinggu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMinggu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(cbMinggu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMinggu6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(cbMinggu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMinggu7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(cbMinggu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMinggu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
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
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(F_Absensi.modeformabsensi == 1){ // EDIT/MODIFY/UPDATE
            minggu1 = cbMinggu1.getSelectedItem().toString();
            minggu2 = cbMinggu2.getSelectedItem().toString();
            minggu3 = cbMinggu3.getSelectedItem().toString();
            minggu4 = cbMinggu4.getSelectedItem().toString();
            minggu5 = cbMinggu5.getSelectedItem().toString();
            minggu6 = cbMinggu6.getSelectedItem().toString();
            minggu7 = cbMinggu7.getSelectedItem().toString();
            minggu8 = cbMinggu8.getSelectedItem().toString();
            
            try {
                Statement stasql = (Statement)kon.Connect().createStatement(); 
                kueri=("update absensi set minggu1 = '"+minggu1+"', minggu2 = '"+minggu2+"', minggu3 = '"+minggu3+"', minggu4 = '"+minggu4+"', minggu5 = '"+minggu5+"', minggu6 = '"+minggu6+"', minggu7 = '"+minggu7+"', minggu8 = '"+minggu8+"' where id = '"+F_Absensi.n_id+"';");
                stasql.executeUpdate(kueri);
                stasql.close();
                JOptionPane.showMessageDialog(null,"Record Telah Diubah");
                this.setVisible(false);
                new F_Absensi().setVisible(true);
            } catch(Exception t){
                JOptionPane.showMessageDialog(null,"Record Gagal Ditambah\nTerdapat Kesalahan Pada Program");
            }
        } else { // ADD
            npm = txtNpm.getText();
            nama = txtNama.getText();
            kelas = txtKelas.getText();
            praktikum = cbPraktikum.getSelectedItem().toString();
            minggu1 = cbMinggu1.getSelectedItem().toString();
            minggu2 = cbMinggu2.getSelectedItem().toString();
            minggu3 = cbMinggu3.getSelectedItem().toString();
            minggu4 = cbMinggu4.getSelectedItem().toString();
            minggu5 = cbMinggu5.getSelectedItem().toString();
            minggu6 = cbMinggu6.getSelectedItem().toString();
            minggu7 = cbMinggu7.getSelectedItem().toString();
            minggu8 = cbMinggu8.getSelectedItem().toString();
            
            if(id_praktikan != null || id_praktikan != ""){
                try {
                    Statement stasql = (Statement)kon.Connect().createStatement();
                    kueri=("insert into absensi (id_praktikan,praktikum,minggu1,minggu2,minggu3,minggu4,minggu5,minggu6,minggu7,minggu8) values ('"+id_praktikan+"','"+praktikum+"','"+minggu1+"','"+minggu2+"','"+minggu3+"','"+minggu4+"','"+minggu5+"','"+minggu6+"','"+minggu7+"','"+minggu8+"');");
                    stasql.executeUpdate(kueri);
                    stasql.close();
                    JOptionPane.showMessageDialog(null,"Record Telah Ditambah");
                    this.setVisible(false);
                    new F_Absensi().setVisible(true);
                } catch(Exception t){
                    JOptionPane.showMessageDialog(null,"Record Gagal Ditambahkan");
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtNpmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNpmKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtNpmKeyTyped

    private void txtNpmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNpmKeyReleased
        // TODO add your handling code here:
        String npmInput = txtNpm.getText();
        try {
            Statement stasql = (Statement)kon.Connect().createStatement();
            kueri=("SELECT * FROM praktikan WHERE npm = '"+npmInput+"';");
            ResultSet rs = stasql.executeQuery(kueri);
            while(rs.next()) {
                txtNama.setText(rs.getString("nama"));
                txtKelas.setText(rs.getString("kelas"));
                id_praktikan = rs.getString("id");
            }
            rs.close();
            stasql.close();
        } catch(Exception t){
            JOptionPane.showMessageDialog(null,"Gagal Mendapatkan Data Praktikan Dengan NPM " + npmInput);
        }
    }//GEN-LAST:event_txtNpmKeyReleased

    private void txtNpmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNpmKeyPressed
        // TODO add your handling code here:
        txtNama.setText("");
        txtKelas.setText("");
        id_praktikan = null;
    }//GEN-LAST:event_txtNpmKeyPressed

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
            java.util.logging.Logger.getLogger(F_FormAbsensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_FormAbsensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_FormAbsensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_FormAbsensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_FormAbsensi().setVisible(true);
            }
        });
    }
    
    public void setCbPraktikum() {
        try{
            Statement stasql = (Statement)kon.Connect().createStatement();
            ResultSet runkueri = stasql.executeQuery("select * from matprak");
            while (runkueri.next()) {
                cbPraktikum.addItem(runkueri.getString("praktikum"));
            }
            stasql.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Gagal mengambil data mata praktikum");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbMinggu1;
    private javax.swing.JComboBox cbMinggu2;
    private javax.swing.JComboBox cbMinggu3;
    private javax.swing.JComboBox cbMinggu4;
    private javax.swing.JComboBox cbMinggu5;
    private javax.swing.JComboBox cbMinggu6;
    private javax.swing.JComboBox cbMinggu7;
    private javax.swing.JComboBox cbMinggu8;
    private javax.swing.JComboBox cbPraktikum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtKelas;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNpm;
    // End of variables declaration//GEN-END:variables
}
