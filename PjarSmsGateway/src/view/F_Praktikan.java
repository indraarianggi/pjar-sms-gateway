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
public class F_Praktikan extends javax.swing.JFrame {
    
    private DatabaseConnection kon;
    private String kueri;
    public static int modeformpraktikan;
    public static String n_id;

    /**
     * Creates new form F_Praktikan
     */
    public F_Praktikan() {
        initComponents();
        setResizable(false);
        kon = new DatabaseConnection();
        modeformpraktikan = 0;
        String n_id = "";
        
        setCbClass();
        
        try {
            getData();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(F_Praktikan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(F_Praktikan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(F_Praktikan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //digunakan untuk mengambil respon klik user di header table
        //JTableHeader header = tblPraktikan.getTableHeader();
        //header.addMouseListener(new TableListener(tblPraktikan));
        
        //digunakan untuk mengambil respon klik di baris
        tblPraktikan.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row = tblPraktikan.rowAtPoint(evt.getPoint());
                int col = tblPraktikan.columnAtPoint(evt.getPoint());
                //JOptionPane.showMessageDialog(null, "baris ke - "+row);
                if(col!=0){
                    Boolean check = Boolean.valueOf(tblPraktikan.getValueAt(row, 0).toString());
                    if(check){
                        tblPraktikan.setValueAt(false, row, 0);
                    }else{
                        tblPraktikan.setValueAt(true, row, 0);
                    }
                }
            }
        });
        
        cbClass.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kelas = cbClass.getSelectedItem().toString().toUpperCase();
                System.out.println(kelas);
                try {
                    if(kelas=="ALL"){
                        getData();
                    }else{
                        getData(kelas);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(F_Praktikan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(F_Praktikan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(F_Praktikan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        txtName.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println(txtName.getText());
                String kelas = cbClass.getSelectedItem().toString().toUpperCase();
                
                try {
                    if(kelas=="ALL"){
                        getData(txtName.getText());
                    }else{
                        getData(kelas, txtName.getText());
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(F_Praktikan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(F_Praktikan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(F_Praktikan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                
                System.out.println(txtName.getText());
                String kelas = cbClass.getSelectedItem().toString().toUpperCase();
                
                try {
                    if(kelas=="ALL"){
                        getData(kelas, txtName.getText());
                    }else{
                        getData(txtName.getText());
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(F_Praktikan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(F_Praktikan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(F_Praktikan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println(txtName.getText());
            }
        });
    }
    
    private void getData() throws ClassNotFoundException, SQLException, IOException{
        String query = "SELECT * FROM praktikan";
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
                sql.getString("id"),
                sql.getString("npm"),
                sql.getString("nama"),
                sql.getString("kelas"),
                sql.getString("telepon")
            });
            i++;
        }
        
        String namakolom[] = {"","No","ID","NPM","Nama","Kelas", "Telepon"};
        //DefaultTableModel model = new DefaultTableModel(isi,namakolom);
        
        tblPraktikan.setModel(c_model);
    }
    
    private void getData(String cari) throws ClassNotFoundException, SQLException, IOException{
        String query = "SELECT * FROM praktikan WHERE kelas like '%"+cari+"%' || nama like '%"+cari+"%'";
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
                sql.getString("id"),
                sql.getString("npm"),
                sql.getString("nama"),
                sql.getString("kelas"),
                sql.getString("telepon")
            });
            i++;
        }
        
        String namakolom[] = {"","No","ID","NPM","Nama","Kelas", "Telepon"};
        //DefaultTableModel model = new DefaultTableModel(isi,namakolom);
        
        tblPraktikan.setModel(c_model);
    }
    
    private void getData(String kelas, String nama) throws ClassNotFoundException, SQLException, IOException{
        String query = "SELECT * FROM praktikan WHERE kelas like '%"+kelas+"%' && nama like '%"+nama+"%'";
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
                sql.getString("id"),
                sql.getString("npm"),
                sql.getString("nama"),
                sql.getString("kelas"),
                sql.getString("telepon")
            });
            i++;
        }
        
        String namakolom[] = {"","No","ID","NPM","Nama","Kelas", "Telepon"};
        //DefaultTableModel model = new DefaultTableModel(isi,namakolom);
        
        tblPraktikan.setModel(c_model);
    }
    
    private class customTableModel extends DefaultTableModel{
        public customTableModel() {
            super(new String[]{"Ceklis","No","ID","NPM","Nama","Kelas","Telepon"},0);
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
                default :
                    return String.class;
            }
        }
        
//        @Override
//        public boolean isCellEditable(int row, int column) {
//          return column == 0;
//        }
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
        tblPraktikan = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnMessage = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbClass = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRAKTIKAN");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        tblPraktikan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPraktikan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPraktikanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPraktikan);

        btnAdd.setBackground(new java.awt.Color(0, 153, 102));
        btnAdd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 153, 102));
        btnAdd.setText("ADD");
        btnAdd.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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

        btnMessage.setBackground(new java.awt.Color(0, 153, 102));
        btnMessage.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnMessage.setForeground(new java.awt.Color(0, 153, 102));
        btnMessage.setText("MESSAGE");
        btnMessage.setToolTipText("");
        btnMessage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnMessage.setContentAreaFilled(false);
        btnMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Class : ");

        cbClass.setBackground(new java.awt.Color(0, 153, 102));
        cbClass.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbClass.setForeground(new java.awt.Color(0, 153, 102));
        cbClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "all" }));
        cbClass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbClassItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cbClass, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtName))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
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
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
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

    private void cbClassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbClassItemStateChanged
        // TODO add your handling code here:
        txtName.setText("");
        try {
            getData(cbClass.getSelectedItem().toString().toUpperCase());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(F_Praktikan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(F_Praktikan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(F_Praktikan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbClassItemStateChanged

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        modeformpraktikan = 0;
        this.setVisible(false);        
        F_FormPraktikan form_praktikan = new F_FormPraktikan("Add Praktikan");
        form_praktikan.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if(modeformpraktikan == 1){
            int row = tblPraktikan.getSelectedRow();
            n_id = (String) tblPraktikan.getValueAt(row, 2);
            this.setVisible(false);
            new F_FormPraktikan("Edit Data Praktikan").setVisible(true);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tblPraktikanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPraktikanMouseClicked
        // TODO add your handling code here:
        modeformpraktikan = 1;
    }//GEN-LAST:event_tblPraktikanMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(modeformpraktikan == 1){
            int row = tblPraktikan.getSelectedRow();
            n_id = (String) tblPraktikan.getValueAt(row, 2);
            try {
                Statement stasql = (Statement)kon.Connect().createStatement(); 
                kueri=("delete from praktikan where id = '"+n_id+"';");
                stasql.executeUpdate(kueri);
                stasql.close();
                JOptionPane.showMessageDialog(null,"Record Telah Dihapus");
                this.setVisible(false);
                new F_Praktikan().setVisible(true);
            } catch(Exception t){
                JOptionPane.showMessageDialog(null,"Record Gagal Dihapus\nTerdapat Kesalahan Pada Program");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageActionPerformed
        // TODO add your handling code here:
        if(modeformpraktikan == 1){
            int count_check = 0;
            ArrayList telepon = new ArrayList();
            for(int i = 0;i<tblPraktikan.getRowCount();i++){
                Boolean check = Boolean.valueOf(tblPraktikan.getValueAt(i,0).toString());
                String no_tlp = tblPraktikan.getValueAt(i, 6).toString();
                if(check){
                    count_check +=1;
                    telepon.add(no_tlp);
                }
            }
            for(int i=0;i<telepon.size();i++){
                System.out.println(telepon.get(i).toString());
            }
            try {
                //pgBar.setVisible(true);
                // BUKA F_FormMessage !!!!
                F_FormMessage form_message = new F_FormMessage("Send Message To Praktikan", telepon);
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
            java.util.logging.Logger.getLogger(F_Praktikan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_Praktikan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_Praktikan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_Praktikan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Praktikan().setVisible(true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnMessage;
    private javax.swing.JComboBox cbClass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPraktikan;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
